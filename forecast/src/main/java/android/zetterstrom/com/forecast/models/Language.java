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
 * [language] may be ar (Arabic), bs (Bosnian), cs (Czech), de (German), el (Greek),
 * en (English, which is the default), es (Spanish), fr (French), hr (Croatian), hu (Hungarian),
 * it (Italian), nl (Dutch), pl (Polish), pt (Portuguese), ru (Russian), sk (Slovak), sr (Serbian),
 * sv (Swedish), tet (Tetum), tr (Turkish), uk (Ukrainian), x-pig-latin (Igpay Atinlay),
 * zh (simplified Chinese), or zh-tw (traditional Chinese).
 * <p/>
 * Created by Kevin Zetterstrom on 2/11/16.
 */
public enum Language {
    @SerializedName(ModelConstants.LANGUAGE_ARABIC)
    ARABIC(ModelConstants.LANGUAGE_ARABIC),
    @SerializedName(ModelConstants.LANGUAGE_BOSNIAN)
    BOSNIAN(ModelConstants.LANGUAGE_BOSNIAN),
    @SerializedName(ModelConstants.LANGUAGE_CZECH)
    CZECH(ModelConstants.LANGUAGE_CZECH),
    @SerializedName(ModelConstants.LANGUAGE_GERMAN)
    GERMAN(ModelConstants.LANGUAGE_GERMAN),
    @SerializedName(ModelConstants.LANGUAGE_GREEK)
    GREEK(ModelConstants.LANGUAGE_GREEK),
    @SerializedName(ModelConstants.LANGUAGE_ENGLISH)
    ENGLISH(ModelConstants.LANGUAGE_ENGLISH),
    @SerializedName(ModelConstants.LANGUAGE_SPANISH)
    SPANISH(ModelConstants.LANGUAGE_SPANISH),
    @SerializedName(ModelConstants.LANGUAGE_FRENCH)
    FRENCH(ModelConstants.LANGUAGE_FRENCH),
    @SerializedName(ModelConstants.LANGUAGE_CROATIAN)
    CROATIAN(ModelConstants.LANGUAGE_CROATIAN),
    @SerializedName(ModelConstants.LANGUAGE_HUNGARIAN)
    HUNGARIAN(ModelConstants.LANGUAGE_HUNGARIAN),
    @SerializedName(ModelConstants.LANGUAGE_ITALIAN)
    ITALIAN(ModelConstants.LANGUAGE_ITALIAN),
    @SerializedName(ModelConstants.LANGUAGE_DUTCH)
    DUTCH(ModelConstants.LANGUAGE_DUTCH),
    @SerializedName(ModelConstants.LANGUAGE_POLISH)
    POLISH(ModelConstants.LANGUAGE_POLISH),
    @SerializedName(ModelConstants.LANGUAGE_PORTUGUESE)
    PORTUGUESE(ModelConstants.LANGUAGE_PORTUGUESE),
    @SerializedName(ModelConstants.LANGUAGE_RUSSIAN)
    RUSSIAN(ModelConstants.LANGUAGE_RUSSIAN),
    @SerializedName(ModelConstants.LANGUAGE_SLOVAK)
    SLOVAK(ModelConstants.LANGUAGE_SLOVAK),
    @SerializedName(ModelConstants.LANGUAGE_SERBIAN)
    SERBIAN(ModelConstants.LANGUAGE_SERBIAN),
    @SerializedName(ModelConstants.LANGUAGE_SWEDISH)
    SWEDISH(ModelConstants.LANGUAGE_SWEDISH),
    @SerializedName(ModelConstants.LANGUAGE_TETUM)
    TETUM(ModelConstants.LANGUAGE_TETUM),
    @SerializedName(ModelConstants.LANGUAGE_TURKISH)
    TURKISH(ModelConstants.LANGUAGE_TURKISH),
    @SerializedName(ModelConstants.LANGUAGE_UKRAINIAN)
    UKRAINIAN(ModelConstants.LANGUAGE_UKRAINIAN),
    @SerializedName(ModelConstants.LANGUAGE_PIG_LATIN)
    PIG_LATIN(ModelConstants.LANGUAGE_PIG_LATIN),
    @SerializedName(ModelConstants.LANGUAGE_SIMPLIFIED_CHINESE)
    SIMPLIFIED_CHINESE(ModelConstants.LANGUAGE_SIMPLIFIED_CHINESE),
    @SerializedName(ModelConstants.LANGUAGE_TRADITIONAL_CHINESE)
    TRADITIONAL_CHINESE(ModelConstants.LANGUAGE_TRADITIONAL_CHINESE);

    private final String mText;

    Language(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @SuppressWarnings("unused")
    public static Language languageFromString(String text) {
        if (text != null) {
            for (Language language : Language.values()) {
                if (text.equalsIgnoreCase(language.mText)) {
                    return language;
                }
            }
        }
        return null;
    }
}
