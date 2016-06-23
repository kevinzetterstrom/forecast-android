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
 * Icons for types of weather
 * <p/>
 * Created by Kevin Zetterstrom on 2/11/16.
 */
public enum Icon {

    @SerializedName(ModelConstants.ICON_CLEAR_DAY)
    CLEAR_DAY(ModelConstants.ICON_CLEAR_DAY),
    @SerializedName(ModelConstants.ICON_CLEAR_NIGHT)
    CLEAR_NIGHT(ModelConstants.ICON_CLEAR_NIGHT),
    @SerializedName(ModelConstants.ICON_RAIN)
    RAIN(ModelConstants.ICON_RAIN),
    @SerializedName(ModelConstants.ICON_SNOW)
    SNOW(ModelConstants.ICON_SNOW),
    @SerializedName(ModelConstants.ICON_SLEET)
    SLEET(ModelConstants.ICON_SLEET),
    @SerializedName(ModelConstants.ICON_WIND)
    WIND(ModelConstants.ICON_WIND),
    @SerializedName(ModelConstants.ICON_FOG)
    FOG(ModelConstants.ICON_FOG),
    @SerializedName(ModelConstants.ICON_CLOUDY)
    CLOUDY(ModelConstants.ICON_CLOUDY),
    @SerializedName(ModelConstants.ICON_PARTLY_CLOUDY_DAY)
    PARTLY_CLOUDY_DAY(ModelConstants.ICON_PARTLY_CLOUDY_DAY),
    @SerializedName(ModelConstants.ICON_PARTLY_CLOUDY_NIGHT)
    PARTLY_CLOUDY_NIGHT(ModelConstants.ICON_PARTLY_CLOUDY_NIGHT),
    @SerializedName(ModelConstants.ICON_HAIL)
    HAIL(ModelConstants.ICON_HAIL),
    @SerializedName(ModelConstants.ICON_THUNDERSTORM)
    THUNDERSTORM(ModelConstants.ICON_THUNDERSTORM),
    @SerializedName(ModelConstants.ICON_TORNADO)
    TORNADO(ModelConstants.ICON_TORNADO);

    private final String mText;

    Icon(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @SuppressWarnings("unused")
    public static Icon iconFromString(String text) {
        if (text != null) {
            for (Icon icon : Icon.values()) {
                if (text.equalsIgnoreCase(icon.mText)) {
                    return icon;
                }
            }
        }
        return null;
    }
}
