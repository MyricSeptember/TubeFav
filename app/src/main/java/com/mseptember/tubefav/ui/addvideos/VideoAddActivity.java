package com.mseptember.tubefav.ui.addvideos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mseptember.tubefav.R;
import com.mseptember.tubefav.injection.Injectable;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class VideoAddActivity extends AppCompatActivity implements HasSupportFragmentInjector, Injectable {

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}
