package com.moac.android.myrssreader.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "item")
public class FeedItem {

    @Element
    private String title;

    @Element
    private String description;

    @Element
    private String link;

    @Element
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    /**
     * The date, example: "Sun, 06 Sep 2015 23:15:41 GMT"
     *
     * @return a String representation of the Date.
     */
    public String getPublishedDate() {
        return pubDate;
    }
}
