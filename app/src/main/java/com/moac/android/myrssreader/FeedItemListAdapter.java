package com.moac.android.myrssreader;

import com.moac.android.myrssreader.model.FeedItem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Creates View items to be displayed in a RecyclerView, populated with data.
 */
public class FeedItemListAdapter extends RecyclerView.Adapter<FeedItemListAdapter.ViewHolder> {

    private List<FeedItem> dataset;

    public FeedItemListAdapter(final List<FeedItem> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // Create a new View instances from the XML layout definition.
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.view_feed_item, parent, false);
        return new ViewHolder(view);
    }

    // Bind a View (new or recycled) to a data item.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(dataset.get(position));
    }

    // Returns the size of the dataset.
    @Override
    public int getItemCount() {
        return dataset.size();
    }

    /**
     * A recycleable representation of a View entity.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;
        private final TextView descriptionTextView;

        ViewHolder(View view) {
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.textView_title);
            descriptionTextView = (TextView) view.findViewById(R.id.textView_description);
        }

        /**
         * Bind a FeedItem data model to the View.
         */
        void bindItem(final FeedItem feedItem) {
            titleTextView.setText(feedItem.getTitle());
            descriptionTextView.setText(feedItem.getDescription());
        }

    }
}
