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
package android.zetterstrom.com.forecast;

/**
 * Constants used for the forecast client
 * Created by Kevin Zetterstrom on 2/11/16.
 */
public final class Constants {

    static final String API_BASE_URL = "https://api.forecast.io/forecast/";

    static final String OPTIONS_LANGUAGE = "lang";
    static final String OPTIONS_UNIT = "units";
    static final String OPTIONS_EXTEND = "extend";
    static final String OPTIONS_EXTEND_HOURLY = "hourly";
    static final String OPTIONS_EXCLUDE = "exclude";
    public static final String OPTIONS_EXCLUDE_CURRENLY = "currently";
    public static final String OPTIONS_EXCLUDE_MINUTELY = "minutely";
    public static final String OPTIONS_EXCLUDE_HOURLY = "hourly";
    public static final String OPTIONS_EXCLUDE_DAILY = "daily";
    public static final String OPTIONS_EXCLUDE_ALERTS = "alerts";
    public static final String OPTIONS_EXCLUDE_FLAGS = "flags";

    static final int DEFAULT_CACHE_AGE = 60 * 60 * 6; // 6 hours
    static final int DEFAULT_CACHE_SIZE = 5 * 1024 * 1024; // 5MB;
    static final int DEFAULT_CONNECTION_TIMEOUT = 60; // seconds

    private Constants() {
    }
}
