package com.mseptember.tubefav.injection;

import com.mseptember.tubefav.ui.addvideos.VideoAddActivity;
import com.mseptember.tubefav.ui.detailvideos.VideoDetailActivity;
import com.mseptember.tubefav.ui.listvideos.VideoListActivity;

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
