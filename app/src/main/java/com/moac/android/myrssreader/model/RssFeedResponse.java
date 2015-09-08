package com.moac.android.myrssreader.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Simple-XML deserialization.
 *
 * @see <a href="http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php">Simple-XML</a>
 */
@Root(strict = false)
public class RssFeedResponse {

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
