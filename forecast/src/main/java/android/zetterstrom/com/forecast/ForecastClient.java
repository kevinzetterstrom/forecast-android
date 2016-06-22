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

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.zetterstrom.com.forecast.models.DataBlock;
import android.zetterstrom.com.forecast.models.Forecast;
import android.zetterstrom.com.forecast.models.Language;
import android.zetterstrom.com.forecast.models.Unit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton class for interacting with the Forecast.io API
 * <p/>
 * Setup: To initialize the ForecastClient class, you must first call {@link #create(ForecastConfiguration)}
 * with a valid {@link ForecastConfiguration}. After creating the ForecastClient, you may obtain a reference
 * to it at any time using the {@link #getInstance()} method.
 * <p/>
 * Use: Once initialized, you may obtain a {@link Forecast} by calling any of the getForecast* methods. It is
 * recommended that you use an asynchronous method unless you are handling threading yourself.
 * <p/>
 * <p/>
 * Created by Kevin Zetterstrom  on 2/9/16.
 */
public final class ForecastClient {

    @Nullable
    private final Language mLanguage;
    @Nullable
    private final Unit mUnit;

    @Nullable
    private List<String> mExcludeBlocks;

    private final String mApiKey;
    private final String mCacheControl;
    private final ForecastService mService;
    private static ForecastClient mInstance;

    private ForecastClient(ForecastConfiguration forecastConfiguration) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .client(createOkHttpClient(forecastConfiguration))
                .build();
        mApiKey = forecastConfiguration.getApiKey();
        mLanguage = forecastConfiguration.getDefaultLanguage();
        mUnit = forecastConfiguration.getDefaultUnit();
        if (forecastConfiguration.getDefaultExcludeList() != null) {
            mExcludeBlocks = new ArrayList<>(forecastConfiguration.getDefaultExcludeList());
        }
        CacheControl cacheControl =
                new CacheControl.Builder().maxAge(forecastConfiguration.getCacheMaxAge(), TimeUnit.SECONDS)
                        .build();
        mCacheControl = cacheControl.toString();
        mService = retrofit.create(ForecastService.class);
    }

    /**
     * Applications must call create to configure the ForecastClient singleton
     *
     * @param forecastConfiguration Use the {@link ForecastConfiguration.Builder} to set the api key and
     *                              initialize the default values for use with the ForecastClient
     */
    public static void create(@NonNull ForecastConfiguration forecastConfiguration) {
        mInstance = new ForecastClient(forecastConfiguration);
    }

    /**
     * Singleton accessor
     * <p/>
     * Will throw an exception if {@link #create(ForecastConfiguration)} was never called
     *
     * @return the ForecastClient singleton
     */
    public static ForecastClient getInstance() {
        if (mInstance == null) {
            throw new AssertionError("Did you forget to call create() ?");
        }
        return mInstance;
    }

    private static OkHttpClient createOkHttpClient(ForecastConfiguration forecastConfiguration) {
        OkHttpClient client = new OkHttpClient();
        client = client.newBuilder()
                .cache(forecastConfiguration.getCache())
                .connectTimeout(forecastConfiguration.getConnectionTimeout(), TimeUnit.SECONDS)
                .readTimeout(forecastConfiguration.getConnectionTimeout(), TimeUnit.SECONDS)
                .build();

        return client;
    }

    private static Gson createGson() {
        final long MILLIS = 1000;
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong() * MILLIS);
            }
        });

        return builder.create();
    }

    /**
     * Synchronous forecast call
     *
     * @param latitude  latitude of the location
     * @param longitude longitude of the location
     * @return the Response object with a Forecast
     * @throws IOException
     */
    @SuppressWarnings("unused")
    public Response<Forecast> getForecastSync(double latitude, double longitude) throws IOException {
        return getForecastSync(latitude, longitude, null);
    }

    /**
     * Synchronous forecast call
     *
     * @param latitude  latitude of the location
     * @param longitude longitude of the location
     * @param time      Nullable (optional) time to add to the request
     * @return the Response object with a Forecast
     * @throws IOException
     */
    public Response<Forecast> getForecastSync(double latitude, double longitude, @Nullable Double time)
            throws IOException {
        return getForecastSync(latitude, longitude, time, null, null, null, false);
    }

    /**
     * Synchronous forecast call
     *
     * @param latitude     latitude of the location
     * @param longitude    longitude of the location
     * @param time         Nullable (optional) time to add to the request
     * @param language     Nullable {@link Language}, if null, will be the default from the {@link ForecastConfiguration}
     * @param unit         Nullable {@link Unit}, if null, will be the default from the {@link ForecastConfiguration}
     * @param excludeList  Nullable List of blocks to exclude, if null, will be the default from the
     *                     {@link ForecastConfiguration}. Values may include
     *                     {@link Constants#OPTIONS_EXCLUDE_CURRENLY},
     *                     {@link Constants#OPTIONS_EXCLUDE_MINUTELY},
     *                     {@link Constants#OPTIONS_EXCLUDE_HOURLY}
     *                     {@link Constants#OPTIONS_EXCLUDE_DAILY},
     *                     {@link Constants#OPTIONS_EXCLUDE_ALERTS},
     *                     {@link Constants#OPTIONS_EXCLUDE_FLAGS}
     * @param extendHourly if true, will extend the hourly {@link DataBlock} with data for 7 days, rather
     *                     than the default of 2
     * @return the Response object with a Forecast
     * @throws IOException
     */
    public Response<Forecast> getForecastSync(double latitude, double longitude, @Nullable Double time,
                                              @Nullable Language language, @Nullable Unit unit,
                                              @Nullable List<String> excludeList, boolean extendHourly)
            throws IOException {

        Call<Forecast> forecastCall = mService.getForecast(mApiKey, getLocation(longitude, latitude, time),
                                                           getQueryMapParameters(language, unit, excludeList,
                                                                                 extendHourly),
                                                           mCacheControl);
        return forecastCall.execute();
    }

    /**
     * Asynchronous Forecast call
     *
     * @param latitude         latitude of the location
     * @param longitude        longitude of the location
     * @param forecastCallback {@link Callback} to be invoked when request completes, with a {@link Forecast}
     * @return {@link Call} object, so that you may cancel the request
     */
    @SuppressWarnings("unused")
    public Call<Forecast> getForecast(double latitude, double longitude,
                                      @NonNull Callback<Forecast> forecastCallback) {
        return getForecast(latitude, longitude, null, forecastCallback);
    }

    /**
     * Asynchronous Forecast call
     *
     * @param latitude         latitude of the location
     * @param longitude        longitude of the location
     * @param time             Nullable (optional) time to add to the request
     * @param forecastCallback {@link Callback} to be invoked when request completes, with a {@link Forecast}
     * @return {@link Call} object, so that you may cancel the request
     */
    public Call<Forecast> getForecast(double latitude, double longitude, @Nullable Double time,
                                      @NonNull Callback<Forecast> forecastCallback) {

        return getForecast(latitude, longitude, time, null, null, null, false, forecastCallback);
    }

    /**
     * Asynchronous Forecast call
     *
     * @param latitude         latitude of the location
     * @param longitude        longitude of the location
     * @param time             Nullable (optional) time to add to the request
     * @param language         Nullable {@link Language}, if null, will be the default from the {@link ForecastConfiguration}
     * @param unit             Nullable {@link Unit}, if null, will be the default from the {@link ForecastConfiguration}
     * @param excludeList      Nullable List of blocks to exclude, if null, will be the default from the
     *                         {@link ForecastConfiguration}. Values may include
     *                         {@link Constants#OPTIONS_EXCLUDE_CURRENLY},
     *                         {@link Constants#OPTIONS_EXCLUDE_MINUTELY},
     *                         {@link Constants#OPTIONS_EXCLUDE_HOURLY}
     *                         {@link Constants#OPTIONS_EXCLUDE_DAILY},
     *                         {@link Constants#OPTIONS_EXCLUDE_ALERTS},
     *                         {@link Constants#OPTIONS_EXCLUDE_FLAGS}
     * @param extendHourly     if true, will extend the hourly {@link DataBlock} with data for 7 days, rather
     *                         than the default of 2
     * @param forecastCallback {@link Callback} to be invoked when request completes, with a {@link Forecast}
     * @return {@link Call} object, so that you may cancel the request
     */
    public Call<Forecast> getForecast(double latitude, double longitude, @Nullable Double time,
                                      @Nullable Language language, @Nullable Unit unit,
                                      @Nullable List<String> excludeList, boolean extendHourly,
                                      @NonNull Callback<Forecast> forecastCallback) {

        Call<Forecast> forecastCall = mService.getForecast(mApiKey, getLocation(longitude, latitude, time),
                                                           getQueryMapParameters(language, unit, excludeList,
                                                                                 extendHourly),
                                                           mCacheControl);

        forecastCall.enqueue(forecastCallback);

        return forecastCall;
    }

    private static String getLocation(double longitude, double latitude, @Nullable Double time) {
        String location = String.valueOf(latitude) + "," + String.valueOf(longitude);
        if (time != null) {
            location += "," + time.toString();
        }
        return location;
    }

    private Map<String, String> getQueryMapParameters(@Nullable Language language, @Nullable Unit unit,
                                                      @Nullable List<String> excludeBlocks,
                                                      boolean extendHourly) {
        Map<String, String> queryMap = new HashMap<>();
        if (language != null) {
            queryMap.put(Constants.OPTIONS_LANGUAGE, language.getText());
        } else if (mLanguage != null) {
            queryMap.put(Constants.OPTIONS_LANGUAGE, mLanguage.getText());
        }
        if (unit != null) {
            queryMap.put(Constants.OPTIONS_UNIT, unit.getText());
        } else if (mUnit != null) {
            queryMap.put(Constants.OPTIONS_UNIT, mUnit.getText());
        }
        if (excludeBlocks != null && !excludeBlocks.isEmpty()) {
            String exclude = TextUtils.join(",", excludeBlocks);
            queryMap.put(Constants.OPTIONS_EXCLUDE, exclude);
        } else if (mExcludeBlocks != null && !mExcludeBlocks.isEmpty()) {
            String exclude = TextUtils.join(",", mExcludeBlocks);
            queryMap.put(Constants.OPTIONS_EXCLUDE, exclude);
        }
        if (extendHourly) {
            queryMap.put(Constants.OPTIONS_EXTEND, Constants.OPTIONS_EXTEND_HOURLY);
        }
        return queryMap;
    }
}
