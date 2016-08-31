# forecast-android
An Android library to integrate the Forecast API into your application


## Contents
 - [Getting Started](#getting-started)
  - [Gradle](#gradle)
  - [Forecast API Registration](#forecast-api-registration)
 - [Reference](#reference)
  - [Configure the library](#configure-the-library)
  - [Make a forecast request](#make-a-forecast-request)

## Getting Started
For a more in depth look at the usage, refer to the [example Android app](app).

### Gradle
Specify the dependency in your `build.gradle` file (make sure `jcenter()` is included as a repository)
```groovy
compile 'android.zetterstrom.com.forecast:forecast:1.2.0'
```

### Forecast API Registration
In order to use the Forecast API, you will need to [register](https://developer.forecast.io) as developer with them, and obtain an API key


## Reference

### Configure the library
Before you can make a request with the Forecast library, you must configure it.
```java
ForecastConfiguration configuration =
    new ForecastConfiguration.Builder(API_KEY)
        .setCacheDirectory(getCacheDir())
        .build();
ForecastClient.create(configuration);
```

### Make a forecast request
```java
double latitude = 40.2712;
double longitude = -74.7829;
ForecastClient.getInstance()
                    .getForecast(latitude, longitude, new Callback<Forecast>() {
                        @Override
                        public void onResponse(Call<Forecast> forecastCall, Response<Forecast> response) {
                            if (response.isSuccess()) {
                                Forecast forecast = response.body();
                            }
                        }

                        @Override
                        public void onFailure(Call<Forecast> forecastCall, Throwable t) {

                        }
                    });
```
