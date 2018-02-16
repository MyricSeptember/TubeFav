package com.mseptember.tubefav.ui.detailVideos;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mseptember.tubefav.R;
import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.injection.Injectable;
import com.mseptember.tubefav.injection.YouFavViewModelFactory;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class VideoDetailFragment extends Fragment implements Injectable {
//TODO Add this to constants class
    static final String YOUTUBE_THUMBNAIL_URL = "http://img.youtube.com/vi/%1$s/0.jpg";
    @Inject
    YouFavViewModelFactory youFavViewModelFactory;
    private int selectedVideoId;
    private EditText editTextTitle, editTextDescription, editTextType, editTextUrl;
    private ImageView imageViewThumbNail;
    private Button buttonAddVideo;
    private VideoDetailViewModel videoDetailViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_video, container, false);

        selectedVideoId = getActivity().getIntent().getIntExtra("selectedVideoId", 0);
        setupViews(view);
        setupViewModel();

        return view;
    }

    private void setupViewModel() {

        videoDetailViewModel = ViewModelProviders.of(this, youFavViewModelFactory).get(VideoDetailViewModel.class);
        videoDetailViewModel.getVideoById(selectedVideoId).observe(this, new Observer<Video>() {
            @Override
            public void onChanged(@Nullable final Video video) {

                editTextTitle.setText(video.getName());
                editTextDescription.setText(video.getDescription());
                editTextType.setText(video.getType());
                editTextUrl.setText(video.getUrl());
                Picasso.with(getActivity()).load(String.format(YOUTUBE_THUMBNAIL_URL, video.getUrl().substring(video.getUrl().lastIndexOf("/") + 1)))
                        .placeholder(R.drawable.gdg).centerCrop()
                        .resize(150, 150)
                        .into(imageViewThumbNail);
                imageViewThumbNail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent playVideoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(video.getUrl()));
                        startActivity(playVideoIntent);
                    }
                });
            }
        });
    }

    private void setupViews(View view) {
        editTextTitle = view.findViewById(R.id.edit_text_title);
        editTextDescription = view.findViewById(R.id.edit_text_description);
        editTextType = view.findViewById(R.id.edit_text_type);
        editTextUrl = view.findViewById(R.id.edit_text_url);
        imageViewThumbNail = view.findViewById(R.id.imageView_main_logo);
        buttonAddVideo = view.findViewById(R.id.button_add);
    }
}
