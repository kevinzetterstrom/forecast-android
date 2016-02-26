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
import android.zetterstrom.com.forecast.models.Language;
import android.zetterstrom.com.forecast.models.Unit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;

/**
 * Used in {@link ForecastClient#create(ForecastConfiguration)} to configure the ForecastClient. The only
 * required parameter is the API key which can be obtained through the Forecast API portal.
 * <p/>
 * <p/>
 * Use the {@link Builder} to create a ForecastConfiguration
 * <p/>
 * Created by Kevin Zetterstrom on 2/11/16.
 */
public class ForecastConfiguration {

    @NonNull
    private String mApiKey;
    @Nullable
    private Language mDefaultLanguage;
    @Nullable
    private Unit mDefaultUnit;
    @Nullable
    private List<String> mDefaultExcludeList;
    @Nullable
    private File mCacheDirectory;
    private int mCacheSize;
    private int mCacheMaxAge; // in seconds
    private int mConnectionTimeout; // in seconds

    private ForecastConfiguration(Builder builder) {
        mApiKey = builder.apiKey;
        mDefaultLanguage = builder.defaultLanguage;
        mDefaultUnit = builder.defaultUnit;
        if (builder.defaultExcludeList != null) {
            mDefaultExcludeList = new ArrayList<>();
            mDefaultExcludeList.addAll(builder.defaultExcludeList);
        }
        mCacheDirectory = builder.cacheDirectory;
        mCacheSize = builder.cacheSize;
        mCacheMaxAge = builder.cacheMaxAge;
        mConnectionTimeout = builder.connectionTimeout;
    }

    @NonNull
    public String getApiKey() {
        return mApiKey;
    }

    @Nullable
    public Language getDefaultLanguage() {
        return mDefaultLanguage;
    }

    @Nullable
    public Unit getDefaultUnit() {
        return mDefaultUnit;
    }

    @Nullable
    public List<String> getDefaultExcludeList() {
        return mDefaultExcludeList;
    }

    @Nullable
    public Cache getCache() {
        if (mCacheDirectory == null) {
            return null;
        }
        return new Cache(mCacheDirectory, mCacheSize);
    }

    public int getCacheMaxAge() {
        return mCacheMaxAge;
    }

    public int getConnectionTimeout() {
        return mConnectionTimeout;
    }

    public static class Builder {

        private String apiKey;
        @Nullable
        private Language defaultLanguage;
        @Nullable
        private Unit defaultUnit;
        @Nullable
        private List<String> defaultExcludeList;
        @Nullable
        private File cacheDirectory;
        private int cacheSize = Constants.DEFAULT_CACHE_SIZE;
        private int cacheMaxAge = Constants.DEFAULT_CACHE_AGE;
        private int connectionTimeout = Constants.DEFAULT_CONNECTION_TIMEOUT;

        public Builder(@NonNull String apiKey) {
            this.apiKey = apiKey;
        }

        public Builder setDefaultLanguage(@Nullable Language defaultLanguage) {
            this.defaultLanguage = defaultLanguage;
            return this;
        }

        public Builder setDefaultUnit(@Nullable Unit defaultUnit) {
            this.defaultUnit = defaultUnit;
            return this;
        }

        public Builder setDefaultExcludeList(@Nullable List<String> defaultExcludeList) {
            this.defaultExcludeList = defaultExcludeList;
            return this;
        }

        public Builder setCacheDirectory(@Nullable File cacheDirectory) {
            this.cacheDirectory = cacheDirectory;
            return this;
        }

        public Builder setCacheSize(int cacheSize) {
            this.cacheSize = cacheSize;
            return this;
        }

        public Builder setCacheMaxAge(int cacheMaxAge) {
            this.cacheMaxAge = cacheMaxAge;
            return this;
        }

        public Builder setConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public ForecastConfiguration build() {
            return new ForecastConfiguration(this);
        }
    }
}
