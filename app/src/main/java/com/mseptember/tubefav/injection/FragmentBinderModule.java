package com.mseptember.tubefav.injection;

import com.mseptember.tubefav.ui.addVideos.VideoAddFragment;
import com.mseptember.tubefav.ui.detailVideos.VideoDetailFragment;
import com.mseptember.tubefav.ui.listVideos.VideoListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBinderModule {

    @ContributesAndroidInjector
    abstract VideoListFragment contributeVideoListFragment();

    @ContributesAndroidInjector
    abstract VideoAddFragment contributeVideoAddFragment();

    @ContributesAndroidInjector
    abstract VideoDetailFragment contributeVideoDetailFragment();
}
