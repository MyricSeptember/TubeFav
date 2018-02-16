package com.mseptember.tubefav.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mseptember.tubefav.dao.VideoDao;
import com.mseptember.tubefav.entity.Video;

@Database(entities = {Video.class}, version = 1, exportSchema = false)
public abstract class VideoDatabase extends RoomDatabase {

    public abstract VideoDao videoDao();
}
