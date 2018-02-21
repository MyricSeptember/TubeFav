package com.mseptember.tubefav.util;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.concurrent.CountDownLatch;

/**
 * Created by MSeptember on 2018/02/21.
 */

public class LiveDataUtils {


    /**
    *This is used to make sure the method waits till the data is available from the observer
    */
    public static <T> T getValue(final LiveData<T> liveData)throws InterruptedException{

        final Object[] data=new Object[1];
        final CountDownLatch latch=new CountDownLatch(1);
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(@Nullable T t) {
                data[0] = t;
                latch.countDown();
                liveData.removeObserver(this);

            }
        };
        liveData.observeForever(observer);
        latch.await();
        //noinspection unchecked
        return (T) data[0];



    }
}
