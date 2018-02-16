package com.mseptember.tubefav.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mseptember.tubefav.ui.addVideos.VideoAddViewModel;
import com.mseptember.tubefav.ui.detailVideos.VideoDetailViewModel;
import com.mseptember.tubefav.ui.listVideos.VideoListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(VideoListViewModel.class)
    abstract ViewModel bindVideoListViewModel(VideoListViewModel videoListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(VideoAddViewModel.class)
    abstract ViewModel bindVideoAddViewModel(VideoAddViewModel videoAddViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(VideoDetailViewModel.class)
    abstract ViewModel bindVideoDetailViewModel(VideoDetailViewModel videoDetailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFActory(YouFavViewModelFactory factory);
}
