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

import com.google.gson.annotations.SerializedName;

/**
 * PrecipitationType represents rain, snow, sleet (which applies to each of freezing rain, ice pellets,
 * and “wintery mix”), or hail
 * <p/>
 * Created by Kevin Zetterstrom on 2/11/16.
 */
public enum PrecipitationType {

    @SerializedName(ModelConstants.PRECIPITATION_RAIN)
    RAIN(ModelConstants.PRECIPITATION_RAIN),
    @SerializedName(ModelConstants.PRECIPITATION_SNOW)
    SNOW(ModelConstants.PRECIPITATION_SNOW),
    @SerializedName(ModelConstants.PRECIPITATION_SLEET)
    SLEET(ModelConstants.PRECIPITATION_SLEET),
    @SerializedName(ModelConstants.PRECIPITATION_HAIL)
    HAIL(ModelConstants.PRECIPITATION_HAIL);

    private final String mText;

    PrecipitationType(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @SuppressWarnings("unused")
    public static PrecipitationType precipitationTypeFromString(String text) {
        if (text != null) {
            for (PrecipitationType precipitationType : PrecipitationType.values()) {
                if (text.equalsIgnoreCase(precipitationType.mText)) {
                    return precipitationType;
                }
            }
        }
        return null;
    }
}
