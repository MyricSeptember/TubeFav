package com.mseptember.tubefav.ui.listVideos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.repository.VideoRepository;

import java.util.List;

import javax.inject.Inject;

public class VideoListViewModel extends ViewModel {

    @Inject
    VideoRepository videoRepository;

    @Inject
    public VideoListViewModel() {

    }

    LiveData<List<Video>> getVideos() {

        return videoRepository.getVideos();
    }


}
