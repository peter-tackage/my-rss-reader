package com.moac.android.myrssreader.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Simple-XML deserialization.
 *
 * Refer to: http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php
 */
@Root(strict = false)
public class RssFeedResponse {

    // TODO Parse some more elements and attributes.

    @Element
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @Root(strict = false)
    public static class Channel {

        @ElementList(inline = true)
        private List<FeedItem> feedItems;

        public List<FeedItem> getFeedItems() {
            return feedItems;
        }
    }
}
