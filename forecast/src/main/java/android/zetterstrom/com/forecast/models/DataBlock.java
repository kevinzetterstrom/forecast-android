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
 * A data block object represents the various weather phenomena occurring over a period of time.
 * <p/>
 * Not all fields may contain data. A null field is indicative that it was not present in the response.
 * <p/>
 * <p/>
 * Created by Kevin Zetterstrom on 2/10/16.
 */
@SuppressWarnings("unused")
public class DataBlock implements Serializable {

    private static final long serialVersionUID = 2215428778754516836L;

    @Nullable
    @SerializedName(ModelConstants.FIELD_SUMMARY)
    private String mSummary;

    @Nullable
    @SerializedName(ModelConstants.FIELD_ICON)
    private String mIcon;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DATA)
    private ArrayList<DataPoint> mDataPoints;

    @Nullable
    public String getSummary() {
        return mSummary;
    }

    @Nullable
    public String getIcon() {
        return mIcon;
    }

    @Nullable
    public ArrayList<DataPoint> getDataPoints() {
        return mDataPoints;
    }
}
