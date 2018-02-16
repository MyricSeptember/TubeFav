package com.mseptember.tubefav.ui.addVideos;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mseptember.tubefav.R;
import com.mseptember.tubefav.injection.Injectable;
import com.mseptember.tubefav.injection.YouFavViewModelFactory;

import javax.inject.Inject;

public class VideoAddFragment extends Fragment implements Injectable {

    @Inject
    YouFavViewModelFactory youFavViewModelFactory;
    private EditText editTextTitle, editTextDescription, editTextType, editTextUrl;
    private Button buttonAddVideo;
    private VideoAddViewModel videoAddViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_video, container, false);

        setupViews(view);
        setClickListener();
        setupViewModel();

        return view;
    }

    private void setupViewModel() {

        videoAddViewModel = ViewModelProviders.of(this, youFavViewModelFactory)
                .get(VideoAddViewModel.class);

        editTextTitle.setText(videoAddViewModel.getVideoName());
        editTextDescription.setText(videoAddViewModel.getVideoDescription());
        editTextType.setText(videoAddViewModel.getVideoType());
        //TODO change this. Only for testing
        editTextUrl.setText("https://youtu.be/X-KSrdwCN7s");
    }

    private void setClickListener() {

        editTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                videoAddViewModel.setVideoName(s.toString());
            }
        });

        editTextDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                videoAddViewModel.setVideoDescription(s.toString());
            }
        });

        editTextType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                videoAddViewModel.setVideoType(s.toString());
            }
        });

        editTextUrl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                videoAddViewModel.setVideoUrl(s.toString());
            }
        });
        buttonAddVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoAddViewModel.addVideo();
                VideoAddFragment.this.getActivity().finish();
            }
        });
    }

    private void setupViews(View view) {

        editTextTitle = view.findViewById(R.id.edit_text_title);
        editTextDescription = view.findViewById(R.id.edit_text_description);
        editTextType = view.findViewById(R.id.edit_text_type);
        editTextUrl = view.findViewById(R.id.edit_text_url);
        buttonAddVideo = view.findViewById(R.id.button_add);
    }
}
