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
package android.zetterstrom.com.forecast.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * In general, to determine the weather at a given point in time, one should examine the highest-precision
 * data block defined (minutely, hourly, and daily respectively), taking any data available from from it
 * and falling back to the next-highest precision data block for any properties that are missing for the
 * point in time desired.
 * <p/>
 * Not all fields may contain data. A null field is indicative that it was not present in the response.
 * <p/>
 * <p/>
 * Created by Kevin Zetterstrom on 2/10/16.
 */
@SuppressWarnings("unused")
public class Forecast implements Serializable {

    private static final long serialVersionUID = -2568653365791715874L;

    @SerializedName(ModelConstants.FIELD_LATITUDE)
    private double mLatitude;

    @SerializedName(ModelConstants.FIELD_LONGITUDE)
    private double mLongitude;

    @SerializedName(ModelConstants.FIELD_TIMEZONE)
    private String mTimezone;

    @SerializedName(ModelConstants.FIELD_OFFSET)
    private int mOffset;

    @Nullable
    @SerializedName(ModelConstants.FIELD_CURRENTLY)
    private DataPoint mCurrently;

    @Nullable
    @SerializedName(ModelConstants.FIELD_MINUTELY)
    private DataBlock mMinutely;

    @Nullable
    @SerializedName(ModelConstants.FIELD_HOURLY)
    private DataBlock mHourly;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DAILY)
    private DataBlock mDaily;

    @Nullable
    @SerializedName(ModelConstants.FIELD_ALERTS)
    private ArrayList<Alert> mAlerts;

    @Nullable
    @SerializedName(ModelConstants.FIELD_FLAGS)
    private Flags mFlags;

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public int getOffset() {
        return mOffset;
    }

    @Nullable
    public DataPoint getCurrently() {
        return mCurrently;
    }

    @Nullable
    public DataBlock getMinutely() {
        return mMinutely;
    }

    @Nullable
    public DataBlock getHourly() {
        return mHourly;
    }

    @Nullable
    public DataBlock getDaily() {
        return mDaily;
    }

    @Nullable
    public ArrayList<Alert> getAlerts() {
        return mAlerts;
    }

    @Nullable
    public Flags getFlags() {
        return mFlags;
    }
}
