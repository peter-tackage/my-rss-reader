package com.moac.android.myrssreader;

import com.moac.android.myrssreader.api.BbcRssApi;
import com.moac.android.myrssreader.model.RssFeedResponse;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * This is our main Activity, it will show a list item RSS feed items retrieved from the internet.
 */
public class RssFeedActivity extends AppCompatActivity {

    private static final String TAG = RssFeedActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // See the Activity UI.
        setContentView(R.layout.activity_rss);

        // Use Retrofit to fetch the feed items - this is asynchronous, so supply a set of callbacks,
        // one for success and one for error.
        getBccRssApi().getFeedItems(new Callback<RssFeedResponse>() {
            @Override
            public void success(final RssFeedResponse rssFeedResponse, final Response response) {

                // Report success to the UI via a "Snackbar"
                Snackbar.make(getRootView(),
                              "We received some items: " + rssFeedResponse.getChannel()
                                                                          .getFeedItems()
                                                                          .size(),
                              Snackbar.LENGTH_LONG)
                        .show();
            }

            @Override
            public void failure(final RetrofitError error) {

                // Report failure to the UI.
                Snackbar.make(getRootView(),
                              "Error! " + error,
                              Snackbar.LENGTH_LONG)
                        .show();
                Log.e(TAG, "Error when retrieving feed", error);
            }
        });

    }

    /**
     * A little helper method, every Activity class has access to the Application instance, use
     * that to get a reference to the API interface.
     *
     * @return the singleton instance of the BBC API service.
     */
    private BbcRssApi getBccRssApi() {
        return ((MyRssFeedApplication) getApplication()).getBccRssApi();
    }

    /**
     * Get the Activity's UI content root view.
     *
     * @return the Activity's root view.
     */
    private View getRootView() {
        return findViewById(android.R.id.content);
    }
}
