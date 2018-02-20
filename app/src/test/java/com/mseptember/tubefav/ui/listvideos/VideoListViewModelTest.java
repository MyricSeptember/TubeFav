package com.mseptember.tubefav.ui.listvideos;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.mseptember.tubefav.FakeVideoDataGenerator;
import com.mseptember.tubefav.LiveDataUtils;
import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.repository.VideoRepository;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by MSeptember on 2018/02/20.
 */

public class VideoListViewModelTest {


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Mock
    VideoRepository videoRepository;

    VideoListViewModel videoListViewModel;

    @BeforeClass
    public static void setUpClass() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });

    }

    @AfterClass
    public static void tearDownClass() {

        RxAndroidPlugins.reset();

    }

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        videoListViewModel = new VideoListViewModel();
        videoListViewModel.videoRepository = videoRepository;

    }

    @Test
    public void getVideos() throws InterruptedException {

        MutableLiveData<List<Video>> fakeVideos = FakeVideoDataGenerator.getVideoListMutableData();
        when(videoRepository.getVideos()).thenReturn(fakeVideos);

        List<Video> videosReturned = LiveDataUtils.getValue(videoListViewModel.getVideos());

        verify(videoRepository).getVideos();
        assertEquals(1, videosReturned.size());
        assertEquals("Jim Rohn", videosReturned.get(0).getName());
    }


}
