package com.mseptember.tubefav.injection;

import com.mseptember.tubefav.ui.addvideos.VideoAddFragment;
import com.mseptember.tubefav.ui.detailvideos.VideoDetailFragment;
import com.mseptember.tubefav.ui.listvideos.VideoListFragment;

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
