package com.mseptember.tubefav.repository;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.mseptember.tubefav.dao.VideoDao;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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


}
