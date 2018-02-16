package com.mseptember.tubefav.injection;

import com.mseptember.tubefav.ui.addVideos.VideoAddActivity;
import com.mseptember.tubefav.ui.detailVideos.VideoDetailActivity;
import com.mseptember.tubefav.ui.listVideos.VideoListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBinderModule {

    @ContributesAndroidInjector(modules = FragmentBinderModule.class)
    abstract VideoListActivity bindVideoListActivity();

    @ContributesAndroidInjector(modules = FragmentBinderModule.class)
    abstract VideoAddActivity bindVideoAddActivity();

    @ContributesAndroidInjector(modules = FragmentBinderModule.class)
    abstract VideoDetailActivity bindVideoDetailActivity();
}
