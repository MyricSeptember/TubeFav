package com.mseptember.tubefav.repository;

import android.arch.lifecycle.LiveData;

import com.mseptember.tubefav.dao.VideoDao;
import com.mseptember.tubefav.db.VideoDatabase;
import com.mseptember.tubefav.entity.Video;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.functions.Action;

public class VideoRepositoryImpl implements VideoRepository {

    @Inject
    VideoDao videoDao;

    public VideoRepositoryImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public LiveData<List<Video>> getVideos() {

        return videoDao.getVideos();
    }

    @Override
    public Completable addVideo(final Video video) {

        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                videoDao.addVideo(video);
            }
        });
    }

    @Override
    public Completable updateVideo(final Video video) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                videoDao.updateVideo(video);
            }
        });
    }

    @Override
    public LiveData<Video> getVideo(int videoId) {
        return videoDao.getSelectedVideo(videoId);
    }
}
