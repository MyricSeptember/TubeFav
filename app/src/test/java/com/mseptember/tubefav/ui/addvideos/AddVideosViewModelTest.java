package com.mseptember.tubefav.ui.addvideos;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.mseptember.tubefav.repository.VideoRepository;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by MSeptember on 2018/02/20.
 */

public class AddVideosViewModelTest {

    VideoAddViewModel videoAddViewModel;

    @Mock
    VideoRepository videoRepository;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @BeforeClass
    public static void sestUpClass(){

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });

    }

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        videoAddViewModel = new VideoAddViewModel();
        videoAddViewModel.videoRepository = videoRepository;

    }

    @AfterClass
    public static void tearDownClass(){

        RxAndroidPlugins.reset();

    }

    @Test
    public void addVideo(){

        when(videoRepository.addVideo(any())).thenReturn(Completable.complete());

        videoAddViewModel.addVideo();

        verify(videoRepository).addVideo(any());
    }
}
