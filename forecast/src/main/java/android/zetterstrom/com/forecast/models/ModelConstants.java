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

/**
 * Package private class to hold constants used for model parsing
 * <p/>
 * Created by Kevin Zetterstrom on 2/11/16.
 */
final class ModelConstants {

    // Field strings
    static final String FIELD_TITLE = "title";
    static final String FIELD_DESCRIPTION = "description";
    static final String FIELD_EXPIRES = "expires";
    static final String FIELD_URI = "uri";
    static final String FIELD_SUMMARY = "summary";
    static final String FIELD_ICON = "icon";
    static final String FIELD_DATA = "data";
    static final String FIELD_LATITUDE = "latitude";
    static final String FIELD_LONGITUDE = "longitude";
    static final String FIELD_TIMEZONE = "timezone";
    static final String FIELD_OFFSET = "offset";
    static final String FIELD_CURRENTLY = "currently";
    static final String FIELD_MINUTELY = "minutely";
    static final String FIELD_HOURLY = "hourly";
    static final String FIELD_DAILY = "daily";
    static final String FIELD_ALERTS = "alerts";
    static final String FIELD_FLAGS = "flags";
    static final String FIELD_DARKSKY_UNAVAILABLE = "darksky-unavailable";
    static final String FIELD_DARKSKY_STATIONS = "darksky-stations";
    static final String FIELD_DATAPOINT_STATIONS = "datapoint-stations";
    static final String FIELD_ISD_STATIONS = "isd-stations";
    static final String FIELD_LAMP_STATIONS = "lamp-stations";
    static final String FIELD_MADIS_STATIONS = "madis-stations";
    static final String FIELD_METAR_STATIONS = "metar-stations";
    static final String FIELD_METNO_LICENSE = "metno-license";
    static final String FIELD_SOURCES = "sources";
    static final String FIELD_UNITS = "units";
    static final String FIELD_TIME = "time";
    static final String FIELD_SUNSET_TIME = "sunsetTime";
    static final String FIELD_SUNRISE_TIME = "sunriseTime";
    static final String FIELD_MOON_PHASE = "moonPhase";
    static final String FIELD_NEAREST_STORM_DISTANCE = "nearestStormDistance";
    static final String FIELD_NEAREST_STORM_BEARING = "nearestStormBearing";
    static final String FIELD_PRECIP_INTENSITY = "precipIntensity";
    static final String FIELD_PRECIP_INTENSITY_MAX = "precipIntensityMax";
    static final String FIELD_PRECIP_INTENSITY_MAX_TIME = "precipIntensityMaxTime";
    static final String FIELD_PRECIP_PROBABILITY = "precipProbability";
    static final String FIELD_PRECIP_TYPE = "precipType";
    static final String FIELD_PRECIP_ACCUMULATION = "precipAccumulation";
    static final String FIELD_TEMPERATURE = "temperature";
    static final String FIELD_TEMPERATURE_MIN = "temperatureMin";
    static final String FIELD_TEMPERATURE_MIN_TIME = "temperatureMinTime";
    static final String FIELD_TEMPERATURE_MAX = "temperatureMax";
    static final String FIELD_TEMPERATURE_MAX_TIME = "temperatureMaxTime";
    static final String FIELD_APPARENT_TEMPERATURE = "apparentTemperature";
    static final String FIELD_APPARENT_TEMPERATURE_MIN = "apparentTemperatureMin";
    static final String FIELD_APPARENT_TEMPERATURE_MIN_TIME = "apparentTemperatureMinTime";
    static final String FIELD_APPARENT_TEMPERATURE_MAX = "apparentTemperatureMax";
    static final String FIELD_APPARENT_TEMPERATURE_MAX_TIME = "apparentTemperatureMaxTime";
    static final String FIELD_DEW_POINT = "dewPoint";
    static final String FIELD_WIND_SPEED = "windSpeed";
    static final String FIELD_WIND_BEARING = "windBearing";
    static final String FIELD_CLOUD_COVER = "cloudCover";
    static final String FIELD_HUMIDITY = "humidity";
    static final String FIELD_PRESSURE = "pressure";
    static final String FIELD_VISIBILITY = "visibility";
    static final String FIELD_OZONE = "ozone";

    // Icon enum strings
    static final String ICON_CLEAR_DAY = "clear-day";
    static final String ICON_CLEAR_NIGHT = "clear-night";
    static final String ICON_RAIN = "rain";
    static final String ICON_SNOW = "snow";
    static final String ICON_SLEET = "sleet";
    static final String ICON_WIND = "wind";
    static final String ICON_FOG = "fog";
    static final String ICON_CLOUDY = "cloudy";
    static final String ICON_PARTLY_CLOUDY_DAY = "partly-cloudy-day";
    static final String ICON_PARTLY_CLOUDY_NIGHT = "partly-cloudy-night";
    static final String ICON_HAIL = "hail";
    static final String ICON_THUNDERSTORM = "thunderstorm";
    static final String ICON_TORNADO = "tornado";

    // Language enum strings
    static final String LANGUAGE_ARABIC = "ar";
    static final String LANGUAGE_BOSNIAN = "bs";
    static final String LANGUAGE_CZECH = "cs";
    static final String LANGUAGE_GERMAN = "de";
    static final String LANGUAGE_GREEK = "el";
    static final String LANGUAGE_ENGLISH = "en";
    static final String LANGUAGE_SPANISH = "es";
    static final String LANGUAGE_FRENCH = "fr";
    static final String LANGUAGE_CROATIAN = "hr";
    static final String LANGUAGE_HUNGARIAN = "hu";
    static final String LANGUAGE_ITALIAN = "it";
    static final String LANGUAGE_DUTCH = "nl";
    static final String LANGUAGE_POLISH = "pl";
    static final String LANGUAGE_PORTUGUESE = "pt";
    static final String LANGUAGE_RUSSIAN = "ru";
    static final String LANGUAGE_SLOVAK = "sk";
    static final String LANGUAGE_SERBIAN = "sr";
    static final String LANGUAGE_SWEDISH = "sv";
    static final String LANGUAGE_TETUM = "tet";
    static final String LANGUAGE_TURKISH = "tr";
    static final String LANGUAGE_UKRAINIAN = "uk";
    static final String LANGUAGE_PIG_LATIN = "x-pig-latin";
    static final String LANGUAGE_SIMPLIFIED_CHINESE = "zh";
    static final String LANGUAGE_TRADITIONAL_CHINESE = "zh-tw";

    // PrecipitationType enum string
    static final String PRECIPITATION_RAIN = "rain";
    static final String PRECIPITATION_SNOW = "snow";
    static final String PRECIPITATION_SLEET = "sleet";
    static final String PRECIPITATION_HAIL = "hail";

    // Unit enum strings
    static final String UNIT_US = "us";
    static final String UNIT_SI = "si";
    static final String UNIT_CA = "ca";
    static final String UNIT_UK = "uk";
    static final String UNIT_UK2 = "uk2";
    static final String UNIT_AUTO = "auto";

    private ModelConstants() {
    }
}
