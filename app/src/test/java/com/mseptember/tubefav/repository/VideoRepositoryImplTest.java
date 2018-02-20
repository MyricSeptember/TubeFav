package com.mseptember.tubefav.repository;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.mseptember.tubefav.FakeVideoDataGenerator;
import com.mseptember.tubefav.LiveDataUtils;
import com.mseptember.tubefav.dao.VideoDao;
import com.mseptember.tubefav.entity.Video;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by MSeptember on 2018/02/18.
 */

public class VideoRepositoryImplTest {

    @Mock
    private VideoDao videoDao;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    private VideoRepository videoRepository;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        videoRepository = new VideoRepositoryImpl(videoDao);

    }

    @Test
    public void addVideo_TriggersDbAdd(){
        Video video = FakeVideoDataGenerator.getFakeVideo();
        videoRepository.addVideo(video)
                .test()
                .onComplete();
        verify(videoDao).addVideo(video);
    }

//    @Test
//    public void addVideo_VideoNull_ThrowsIllegalArgumentException(){
//        videoRepository.addVideo(null)
//                .test()
//                .assertError(IllegalArgumentException.class);
//        verify(videoDao,never()).addVideo(null);
//    }

    @Test
    public void getVideo_DaoGetVideos()throws InterruptedException{

        MutableLiveData<List<Video>> fakeVideos = FakeVideoDataGenerator.getVideoListMutableData();
        when(videoDao.getVideos()).thenReturn(fakeVideos);

        List<Video> videosReturned = LiveDataUtils.getValue(videoRepository.getVideos());

        verify(videoDao).getVideos();
        assertArrayEquals(fakeVideos.getValue().toArray(),videosReturned.toArray());
    }







}
