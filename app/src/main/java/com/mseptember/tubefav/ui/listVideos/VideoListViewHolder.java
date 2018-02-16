package com.mseptember.tubefav.ui.listVideos;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mseptember.tubefav.R;

public class VideoListViewHolder extends RecyclerView.ViewHolder {

    TextView videoTextView;
    ImageView videoThumbNailImageView;

    public VideoListViewHolder(View itemView) {
        super(itemView);

        videoTextView = (TextView) itemView.findViewById(R.id.text_video_title);
        videoThumbNailImageView = (ImageView) itemView.findViewById(R.id.video_thumb);
    }
}
