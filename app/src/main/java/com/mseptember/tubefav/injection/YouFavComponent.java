package com.mseptember.tubefav.injection;

import com.mseptember.tubefav.YouFavApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, YouFavModule.class, ActivityBinderModule.class})
public interface YouFavComponent {

    void inject(YouFavApplication youFavApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(YouFavApplication application);

        YouFavComponent build();
    }
}
