package com.mseptember.tubefav.injection;

import android.arch.persistence.room.Room;

import com.mseptember.tubefav.YouFavApplication;
import com.mseptember.tubefav.dao.VideoDao;
import com.mseptember.tubefav.db.VideoDatabase;
import com.mseptember.tubefav.repository.VideoRepository;
import com.mseptember.tubefav.repository.VideoRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

@Module(includes = {AndroidInjectionModule.class, ViewModelModule.class})
public class YouFavModule {

    @Provides
    VideoRepository providesVideoRepository(VideoDao videoDao) {

        return new VideoRepositoryImpl(videoDao);
    }

    @Provides
    @Singleton
    VideoDao providesVideoDao(VideoDatabase videoDatabase){

        return videoDatabase.videoDao();
    }

    @Provides
    @Singleton
    VideoDatabase providesVideoDatabase(YouFavApplication context) {

        return Room.databaseBuilder(context.getApplicationContext(), VideoDatabase.class, "video_db").build();
    }
}
