/*
 * Copyright 2016 Kevin Zetterstrom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.zetterstrom.com.snow.fragments;

import android.Manifest.permission;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.zetterstrom.com.forecast.models.Forecast;
import android.zetterstrom.com.snow.R;
import android.zetterstrom.com.snow.SnowApplication;
import android.zetterstrom.com.snow.callbacks.ForecastCallback;
import android.zetterstrom.com.snow.utils.SnowHelper;

/**
 * Fragment to demo the Forecast API
 * <p/>
 * Created by Kevin Zetterstrom on 2/15/16.
 */
public class SnowFragment extends Fragment {

    private static final int COARSE_PERMISSION_REQUEST_CODE = 0;

    private TextView mSnowAmountTextView;
    private TextView mSnowLabelTextView;
    private ProgressBar mProgressBar;

    @Nullable
    private Forecast mForecast;

    private LocationManager mLocationManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mLocationManager =
                (LocationManager) SnowApplication.getAppContext().getSystemService(Context.LOCATION_SERVICE);
        checkPermission();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snow, container, false);
        mSnowAmountTextView = (TextView) view.findViewById(R.id.fragment_snow_amount_textview);
        mSnowLabelTextView = (TextView) view.findViewById(R.id.fragment_snow_label_textview);
        mProgressBar = (ProgressBar) view.findViewById(R.id.fragment_snow_progressbar);
        showForecast();
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case COARSE_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted; use checkPermission to initiate the call to findLocation
                    checkPermission();
                } else {
                    handleDeniedPermission();
                }
                break;
            }
        }
    }

    public void handleDeniedPermission() {
        boolean showRationale = shouldShowRequestPermissionRationale(permission.ACCESS_COARSE_LOCATION);
        final AlertDialog.Builder builder = new Builder(getContext());
        builder.setTitle(R.string.dialog_permission_error_title).setCancelable(false);
        if (!showRationale) {
            builder.setMessage(R.string.dialog_permission_permanently_denied_message)
                    .setPositiveButton(R.string.dialog_ok, new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (getActivity() != null) {
                                getActivity().finish();
                            }
                        }
                    });

        } else {
            builder.setMessage(R.string.dialog_permission_denied_message)
                    .setPositiveButton(R.string.dialog_retry, new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            requestPermissions(new String[]{permission.ACCESS_COARSE_LOCATION},
                                               COARSE_PERMISSION_REQUEST_CODE);
                        }
                    })
                    .setNegativeButton(R.string.dialog_cancel, new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (getActivity() != null) {
                                getActivity().finish();
                            }
                        }
                    });
        }
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                builder.show();
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{permission.ACCESS_COARSE_LOCATION},
                               COARSE_PERMISSION_REQUEST_CODE);

        } else {
            findLocation();
        }
    }

    @RequiresPermission(permission.ACCESS_COARSE_LOCATION)
    private void findLocation() throws SecurityException {
        Location location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        SnowHelper.getForecast(location, new ForecastCallback() {

            @Override
            public void onForecastSuccess(Forecast forecast) {
                mForecast = forecast;
                showForecast();
            }

            @Override
            public void onForecastError(@Nullable Throwable throwable) {
                showError();
            }
        });
    }

    private void showForecast() {
        if (mForecast != null && mSnowLabelTextView != null && mSnowAmountTextView != null) {
            if (mProgressBar != null) {
                mProgressBar.setVisibility(View.GONE);
            }
            double snowfall = SnowHelper.calculateSnowAccumulation(mForecast);
            if (snowfall == 0.0) {
                mSnowLabelTextView.setText(R.string.snowfall_none);
            } else {
                mSnowLabelTextView.setText(R.string.snowfall_some);
                mSnowAmountTextView.setText(getString(R.string.snowfall_amount, snowfall));
            }
        }
    }

    private void showError() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        if (mSnowLabelTextView != null) {
            mSnowLabelTextView.setText(R.string.snowfall_none);
        }
        if (getView() != null && isAdded()) {
            Snackbar.make(getView(), R.string.snowfall_error, Snackbar.LENGTH_LONG).show();
        }
    }

}
