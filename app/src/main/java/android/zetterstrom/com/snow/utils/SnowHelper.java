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
package android.zetterstrom.com.snow.utils;

import android.content.SharedPreferences;
import android.location.Location;
import android.preference.PreferenceManager;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.models.DataPoint;
import android.zetterstrom.com.forecast.models.Forecast;
import android.zetterstrom.com.forecast.models.PrecipitationType;
import android.zetterstrom.com.snow.SnowApplication;
import android.zetterstrom.com.snow.callbacks.ForecastCallback;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Helper class for getting the Forecast and performing calculations
 * <p/>
 * Created by Kevin Zetterstrom on 2/17/16.
 */
public class SnowHelper {

    private static final String PREVIOUS_LATITUDE = "PREVIOUS_LATITUDE";
    private static final String PREVIOUS_LONGITUDE = "PREVIOUS_LONGITUDE";

    public static void getForecast(Location location, final ForecastCallback callback) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(SnowApplication.getAppContext());
        double previousLatitude = sharedPreferences.getFloat(PREVIOUS_LATITUDE, 0.0f);
        double previousLongitude = sharedPreferences.getFloat(PREVIOUS_LONGITUDE, 0.0f);

        if (location != null) {
            sharedPreferences.edit()
                    .putFloat(PREVIOUS_LATITUDE, (float) location.getLatitude())
                    .putFloat(PREVIOUS_LONGITUDE, (float) location.getLongitude())
                    .apply();
            float[] results = new float[1];
            double forecastLatitude = location.getLatitude();
            double forecastLongitude = location.getLongitude();
            Location.distanceBetween(previousLatitude, previousLongitude, forecastLatitude, forecastLongitude,
                                     results);

            if (results[0] < 50) {
                forecastLatitude = previousLatitude;
                forecastLongitude = previousLongitude;
            }
            ForecastClient.getInstance()
                    .getForecast(forecastLatitude, forecastLongitude, new Callback<Forecast>() {
                        @Override
                        public void onResponse(Response<Forecast> response) {
                            if (response.isSuccess()) {
                                callback.onForecastSuccess(response.body());
                            } else {
                                callback.onForecastError(null);
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            callback.onForecastError(t);
                        }
                    });
        }
    }

    public static double calculateSnowAccumulation(Forecast forecast) {
        double snow = 0.0;
        if (forecast != null && forecast.getDaily() != null &&
            forecast.getDaily().getDataPoints() != null) {
            ArrayList<DataPoint> dailyDataPoints = forecast.getDaily().getDataPoints();
            for (DataPoint dataPoint : dailyDataPoints) {
                if (dataPoint.getPrecipitationType() != null &&
                    dataPoint.getPrecipitationType() == PrecipitationType.SNOW) {
                    if (dataPoint.getPrecipAccumulation() != null) {
                        snow += dataPoint.getPrecipAccumulation();
                    }
                }
            }
        }
        return snow;
    }
}
