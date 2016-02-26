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
package android.zetterstrom.com.snow;

import android.app.Application;
import android.content.Context;
import android.zetterstrom.com.forecast.Constants;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.ForecastConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Application class to initialize the ForecastClient
 * <p/>
 * Created by Kevin Zetterstrom  on 2/9/16.
 */
public class SnowApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        List<String> excludeList = new ArrayList<>();
        excludeList.add(Constants.OPTIONS_EXCLUDE_CURRENLY);
        excludeList.add(Constants.OPTIONS_EXCLUDE_MINUTELY);
        excludeList.add(Constants.OPTIONS_EXCLUDE_ALERTS);
        excludeList.add(Constants.OPTIONS_EXCLUDE_FLAGS);

        ForecastConfiguration configuration =
                new ForecastConfiguration.Builder(BuildConfig.API_KEY).setDefaultExcludeList(excludeList)
                        .setCacheDirectory(getCacheDir())
                        .build();
        ForecastClient.create(configuration);
    }

    public static Context getAppContext() {
        return mContext;
    }
}
