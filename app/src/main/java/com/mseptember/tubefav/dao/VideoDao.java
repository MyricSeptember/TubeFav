package com.mseptember.tubefav.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mseptember.tubefav.entity.Video;

import java.util.List;

@Dao
public interface VideoDao {

    @Query("SELECT * FROM Video")
    LiveData<List<Video>> getVideos();

    @Query("SELECT * FROM  Video WHERE id = :id")
    LiveData<Video> getSelectedVideo(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVideo(Video video);

    @Delete
    void deleteVideo(Video video);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateVideo(Video video);
}
