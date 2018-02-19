package com.mseptember.tubefav.ui.detailvideos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.repository.VideoRepository;

import javax.inject.Inject;

public class VideoDetailViewModel extends ViewModel {

    @Inject
    VideoRepository videoRepository;
    private String videoName;
    private String videoDescription;
    private String videoType;
    private String videoUrl;

    @Inject
    VideoDetailViewModel() {
        //TODO CHECK THIS OUT
    }

    String getVideoName() {
        return videoName;
    }

    void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    String getVideoDescription() {
        return videoDescription;
    }

    void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    String getVideoType() {
        return videoType;
    }

    void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    String getVideoUrl() {
        return videoUrl;
    }

    void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public LiveData<Video> getVideoById(int id) {
        return videoRepository.getVideo(id);
    }

}
