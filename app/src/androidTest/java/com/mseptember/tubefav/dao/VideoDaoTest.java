package com.mseptember.tubefav.dao;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mseptember.tubefav.db.VideoDatabase;
import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.util.LiveDataUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by MSeptember on 2018/02/21.
 */
@RunWith(AndroidJUnit4.class)
public class VideoDaoTest {

    VideoDao videoDao;
    VideoDatabase videoDatabase;

    @Before
    public void setup() {
        videoDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                VideoDatabase.class).build();
        videoDao = videoDatabase.videoDao();
    }

    @Test
    public void addVideo_SuccessfullyAddsVideo() throws InterruptedException {
        Video video = generateTestVideoData(0, "Stanley");
        videoDao.addVideo(video);
        List<Video> videoRetrieved = LiveDataUtils.getValue(videoDao.getVideos());

        assertEquals(video.getName(), videoRetrieved.get(0).getName());
        //TODO delete the event here at a later stage
    }

    Video generateTestVideoData(int id, String name) {
        return new Video(id, name, "Description", "Type", "url");
    }


}
