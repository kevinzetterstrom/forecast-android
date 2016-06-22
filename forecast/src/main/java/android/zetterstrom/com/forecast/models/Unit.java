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
 * Unit represents the several types of measurement units that the Forecast API uses
 * <p/>
 * Created by Kevin Zetterstrom on 2/11/16.
 */
public enum Unit {

    @SerializedName(ModelConstants.UNIT_US)
    US(ModelConstants.UNIT_US),
    @SerializedName(ModelConstants.UNIT_SI)
    SI(ModelConstants.UNIT_SI),
    @SerializedName(ModelConstants.UNIT_CA)
    CA(ModelConstants.UNIT_CA),
    @SerializedName(ModelConstants.UNIT_UK)
    UK(ModelConstants.UNIT_UK),
    @SerializedName(ModelConstants.UNIT_UK2)
    UK2(ModelConstants.UNIT_UK2),
    @SerializedName(ModelConstants.UNIT_AUTO)
    AUTO(ModelConstants.UNIT_AUTO);

    private final String mText;

    Unit(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @SuppressWarnings("unused")
    public static Unit unitFromString(String text) {
        if (text != null) {
            for (Unit unit : Unit.values()) {
                if (text.equalsIgnoreCase(unit.mText)) {
                    return unit;
                }
            }
        }
        return null;
    }
}
