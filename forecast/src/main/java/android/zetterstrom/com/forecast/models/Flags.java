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
 * The flags object contains various metadata information related to the request.
 * <p/>
 * Not all fields may contain data. A null field is indicative that it was not present in the response.
 * <p/>
 * <p/>
 * Created by Kevin Zetterstrom on 2/10/16.
 */
@SuppressWarnings("unused")
public class Flags implements Serializable {

    private static final long serialVersionUID = 2335711403921076215L;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DARKSKY_UNAVAILABLE)
    private String mDarkSkyUnavailable;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DARKSKY_STATIONS)
    private ArrayList<String> mDarkSkyStations;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DATAPOINT_STATIONS)
    private ArrayList<String> mDataPointStations;

    @Nullable
    @SerializedName(ModelConstants.FIELD_ISD_STATIONS)
    private ArrayList<String> mISDStations;

    @Nullable
    @SerializedName(ModelConstants.FIELD_LAMP_STATIONS)
    private ArrayList<String> mLampStations;

    @Nullable
    @SerializedName(ModelConstants.FIELD_MADIS_STATIONS)
    private ArrayList<String> mMadisStations;

    @Nullable
    @SerializedName(ModelConstants.FIELD_METAR_STATIONS)
    private ArrayList<String> mMetarStations;

    @Nullable
    @SerializedName(ModelConstants.FIELD_METNO_LICENSE)
    private String mMetnoLicense;

    @Nullable
    @SerializedName(ModelConstants.FIELD_SOURCES)
    private ArrayList<String> mSources;

    @Nullable
    @SerializedName(ModelConstants.FIELD_UNITS)
    private Unit mUnit;

    @Nullable
    public String getDarkSkyUnavailable() {
        return mDarkSkyUnavailable;
    }

    @Nullable
    public ArrayList<String> getDarkSkyStations() {
        return mDarkSkyStations;
    }

    @Nullable
    public ArrayList<String> getDataPointStations() {
        return mDataPointStations;
    }

    @Nullable
    public ArrayList<String> getISDStations() {
        return mISDStations;
    }

    @Nullable
    public ArrayList<String> getLampStations() {
        return mLampStations;
    }

    @Nullable
    public ArrayList<String> getMadisStations() {
        return mMadisStations;
    }

    @Nullable
    public ArrayList<String> getMetarStations() {
        return mMetarStations;
    }

    @Nullable
    public String getMetnoLicense() {
        return mMetnoLicense;
    }

    @Nullable
    public ArrayList<String> getSources() {
        return mSources;
    }

    @Nullable
    public Unit getUnit() {
        return mUnit;
    }
}
