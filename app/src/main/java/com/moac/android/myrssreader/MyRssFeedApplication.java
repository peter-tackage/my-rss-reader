package com.moac.android.myrssreader;

import android.app.Application;
import android.util.Log;

import com.moac.android.myrssreader.api.BbcRssApi;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.SimpleXMLConverter;

/**
 * The Android system enforces that only a single instance of the Application will exist during
 * the application's lifetime.
 */
public class MyRssFeedApplication extends Application {

    // The singleton instance of the API service.
    private BbcRssApi bbcRssApi;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeFeedApi();
    }

    /**
     * Returns the BBC RSS Feed API for use in other components.
     *
     * @return the singleton instance of the BBC RSS Feed API.
     */
    public BbcRssApi getBccRssApi() {
        return bbcRssApi;
    }

    /**
     * Initialize the Retrofit implemented API service.
     */
    private void initializeFeedApi() {
        RestAdapter feedRestAdapter = new RestAdapter.Builder()
                .setConverter(new SimpleXMLConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(final RetrofitError cause) {
                        Log.e("BbcRestApi", "Error occurred for URL: " + cause.getUrl(), cause);
                        return cause;
                    }
                })
                .setEndpoint("http://feeds.bbci.co.uk/")
                .build();

        bbcRssApi = feedRestAdapter.create(BbcRssApi.class);
    }
}
