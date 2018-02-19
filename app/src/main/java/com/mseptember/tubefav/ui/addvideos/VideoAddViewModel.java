package com.mseptember.tubefav.ui.addvideos;

import android.arch.lifecycle.ViewModel;

import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.repository.VideoRepository;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoAddViewModel extends ViewModel {

    @Inject
    VideoRepository videoRepository;
    private String videoName;
    private String videoDescription;
    private String videoType;
    private String videoUrl;

    @Inject
    VideoAddViewModel() {
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

    void addVideo() {

        Video video = new Video(0, videoName, videoDescription, videoType, videoUrl);
        videoRepository.addVideo(video).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
