package com.mseptember.tubefav.repository;

import android.arch.lifecycle.LiveData;

import com.mseptember.tubefav.entity.Video;

import java.util.List;

import io.reactivex.Completable;

public interface VideoRepository {

    LiveData<List<Video>> getVideos();

    LiveData<Video> getVideo(int videoId);

    Completable addVideo(Video video);

    Completable updateVideo(Video video);
}
