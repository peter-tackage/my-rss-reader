package com.moac.android.myrssreader.api;

import com.moac.android.myrssreader.model.RssFeedResponse;

import retrofit.Callback;
import retrofit.http.GET;

public interface BbcRssApi {

    @GET("/news/rss.xml")
    void getFeedItems(Callback<RssFeedResponse> feedItemsCallback);
}
