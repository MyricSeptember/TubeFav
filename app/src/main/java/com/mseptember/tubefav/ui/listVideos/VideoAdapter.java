package com.mseptember.tubefav.ui.listVideos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mseptember.tubefav.R;
import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoListViewHolder> {
    //TODO Add this to constants class and other.
    static final String YOUTUBE_THUMBNAIL_URL = "http://img.youtube.com/vi/%1$s/0.jpg";

    private final Context context;
    private List<Video> items;
    private View.OnClickListener viewClickListener;

    VideoAdapter(List<Video> items, Context context, View.OnClickListener viewClickListener) {

        this.items = items;
        this.context = context;
        this.viewClickListener = viewClickListener;
    }

    @Override
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_video, parent, false);
        return new VideoListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideoListViewHolder holder, int position) {

        Video item = items.get(position);
        holder.videoTextView.setText(item.getName());
        holder.itemView.setTag(item);

        Picasso.with(context).load(String.format(YOUTUBE_THUMBNAIL_URL, item.getUrl().substring(item.getUrl().lastIndexOf("/") + 1)))
                .placeholder(R.drawable.gdg).centerCrop()
                .resize(150, 150)
                .into(holder.videoThumbNailImageView);

        holder.itemView.setOnClickListener(viewClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void setItems(List<Video> videos) {

        this.items = videos;
        notifyDataSetChanged();

    }


}
