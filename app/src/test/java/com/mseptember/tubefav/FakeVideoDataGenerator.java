package com.mseptember.tubefav;

import android.arch.lifecycle.MutableLiveData;

import com.mseptember.tubefav.entity.Video;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by MSeptember on 2018/02/19.
 */

public class FakeVideoDataGenerator {

    @NonNull
    public static MutableLiveData<List<Video>> getVideoListMutableData(){

        List<Video> videos = new ArrayList<>();
        Video video =getFakeVideo();
        videos.add(video);
        MutableLiveData<List<Video>> fakeVideos=new MutableLiveData<>();
        fakeVideos.setValue(videos);
        return fakeVideos;

    }

    public static Video getFakeVideo(){

        return new Video(1,"Name","Descrip","Type","url");
    }

}
