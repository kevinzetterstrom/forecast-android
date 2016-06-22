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
import java.util.Date;

/**
 * A data point object represents the various weather phenomena occurring at a specific instant of time, and
 * has many varied properties. All of these properties (except time) are optional, and will only be set if
 * we have that type of information for that location and time. Please note that minutely data points are
 * always aligned to the nearest minute boundary, hourly points to the top of the hour, and daily points to
 * midnight of that day.
 * <p/>
 * Data points in the daily data block {@link DataBlock} are special: instead of representing the weather
 * phenomena at a given instant of time, they are an aggregate point representing the weather phenomena that
 * will occur over the entire day. For precipitation fields, this aggregate is a maximum; for other fields,
 * it is an average.
 * <p/>
 * Not all fields may contain data. A null field is indicative that it was not present in the response. This
 * is the reason {@link Double} is used as opposed to the primitive double.
 * <p/>
 * <p/>
 * Created by Kevin Zetterstrom  on 2/10/16.
 */
@SuppressWarnings("unused")
public class DataPoint implements Serializable {

    private static final long serialVersionUID = 1089660797202113138L;

    @SerializedName(ModelConstants.FIELD_TIME)
    private Date mTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_SUMMARY)
    private String mSummary;

    @Nullable
    @SerializedName(ModelConstants.FIELD_ICON)
    private Icon mIcon;

    @Nullable
    @SerializedName(ModelConstants.FIELD_SUNSET_TIME)
    private Date mSunsetTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_SUNRISE_TIME)
    private Date mSunriseTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_MOON_PHASE)
    private Double mMoonPhase;

    @Nullable
    @SerializedName(ModelConstants.FIELD_NEAREST_STORM_DISTANCE)
    private Double mNearestStormDistance;

    @Nullable
    @SerializedName(ModelConstants.FIELD_NEAREST_STORM_BEARING)
    private Double mNearestStormBearing;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRECIP_INTENSITY)
    private Double mPrecipIntensity;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRECIP_INTENSITY_MAX)
    private Double mPrecipIntensityMax;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRECIP_INTENSITY_MAX_TIME)
    private Date mPrecipIntensityMaxTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRECIP_PROBABILITY)
    private Double mPrecipProbability;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRECIP_TYPE)
    private PrecipitationType mPrecipitationType;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRECIP_ACCUMULATION)
    private Double mPrecipAccumulation;

    @Nullable
    @SerializedName(ModelConstants.FIELD_TEMPERATURE)
    private Double mTemperature;

    @Nullable
    @SerializedName(ModelConstants.FIELD_TEMPERATURE_MIN)
    private Double mTemperatureMin;

    @Nullable
    @SerializedName(ModelConstants.FIELD_TEMPERATURE_MIN_TIME)
    private Date mTemperatureMinTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_TEMPERATURE_MAX)
    private Double mTemperatureMax;

    @Nullable
    @SerializedName(ModelConstants.FIELD_TEMPERATURE_MAX_TIME)
    private Date mTemperatureMaxTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_APPARENT_TEMPERATURE)
    private Double mApparentTemperature;

    @Nullable
    @SerializedName(ModelConstants.FIELD_APPARENT_TEMPERATURE_MIN)
    private Double mApparentTemperatureMin;

    @Nullable
    @SerializedName(ModelConstants.FIELD_APPARENT_TEMPERATURE_MIN_TIME)
    private Date mApparentTemperatureMinTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_APPARENT_TEMPERATURE_MAX)
    private Double mApparentTemperatureMax;

    @Nullable
    @SerializedName(ModelConstants.FIELD_APPARENT_TEMPERATURE_MAX_TIME)
    private Date mApparentTemperatureMaxTime;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DEW_POINT)
    private Double mDewPoint;

    @Nullable
    @SerializedName(ModelConstants.FIELD_WIND_SPEED)
    private Double mWindSpeed;

    @Nullable
    @SerializedName(ModelConstants.FIELD_WIND_BEARING)
    private Double mWindBearing;

    @Nullable
    @SerializedName(ModelConstants.FIELD_CLOUD_COVER)
    private Double mCloudCover;

    @Nullable
    @SerializedName(ModelConstants.FIELD_HUMIDITY)
    private Double mHumidity;

    @Nullable
    @SerializedName(ModelConstants.FIELD_PRESSURE)
    private Double mPressure;

    @Nullable
    @SerializedName(ModelConstants.FIELD_VISIBILITY)
    private Double mVisibility;

    @Nullable
    @SerializedName(ModelConstants.FIELD_OZONE)
    private Double mOzone;

    public Date getTime() {
        return mTime;
    }

    @Nullable
    public String getSummary() {
        return mSummary;
    }

    @Nullable
    public Icon getIcon() {
        return mIcon;
    }

    @Nullable
    public Date getSunsetTime() {
        return mSunsetTime;
    }

    @Nullable
    public Date getSunriseTime() {
        return mSunriseTime;
    }

    @Nullable
    public Double getMoonPhase() {
        return mMoonPhase;
    }

    @Nullable
    public Double getNearestStormDistance() {
        return mNearestStormDistance;
    }

    @Nullable
    public Double getNearestStormBearing() {
        return mNearestStormBearing;
    }

    @Nullable
    public Double getPrecipIntensity() {
        return mPrecipIntensity;
    }

    @Nullable
    public Double getPrecipIntensityMax() {
        return mPrecipIntensityMax;
    }

    @Nullable
    public Date getPrecipIntensityMaxTime() {
        return mPrecipIntensityMaxTime;
    }

    @Nullable
    public Double getPrecipProbability() {
        return mPrecipProbability;
    }

    @Nullable
    public PrecipitationType getPrecipitationType() {
        return mPrecipitationType;
    }

    @Nullable
    public Double getPrecipAccumulation() {
        return mPrecipAccumulation;
    }

    @Nullable
    public Double getTemperature() {
        return mTemperature;
    }

    @Nullable
    public Double getTemperatureMin() {
        return mTemperatureMin;
    }

    @Nullable
    public Date getTemperatureMinTime() {
        return mTemperatureMinTime;
    }

    @Nullable
    public Double getTemperatureMax() {
        return mTemperatureMax;
    }

    @Nullable
    public Date getTemperatureMaxTime() {
        return mTemperatureMaxTime;
    }

    @Nullable
    public Double getApparentTemperature() {
        return mApparentTemperature;
    }

    @Nullable
    public Double getApparentTemperatureMin() {
        return mApparentTemperatureMin;
    }

    @Nullable
    public Date getApparentTemperatureMinTime() {
        return mApparentTemperatureMinTime;
    }

    @Nullable
    public Double getApparentTemperatureMax() {
        return mApparentTemperatureMax;
    }

    @Nullable
    public Date getApparentTemperatureMaxTime() {
        return mApparentTemperatureMaxTime;
    }

    @Nullable
    public Double getDewPoint() {
        return mDewPoint;
    }

    @Nullable
    public Double getWindSpeed() {
        return mWindSpeed;
    }

    @Nullable
    public Double getWindBearing() {
        return mWindBearing;
    }

    @Nullable
    public Double getCloudCover() {
        return mCloudCover;
    }

    @Nullable
    public Double getHumidity() {
        return mHumidity;
    }

    @Nullable
    public Double getPressure() {
        return mPressure;
    }

    @Nullable
    public Double getVisibility() {
        return mVisibility;
    }

    @Nullable
    public Double getOzone() {
        return mOzone;
    }
}
