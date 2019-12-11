package com.wd.mvp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * date:2019/12/3
 * author:郑宏宇(Msi)
 * function:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       Fresco.initialize(this);
    }
}
