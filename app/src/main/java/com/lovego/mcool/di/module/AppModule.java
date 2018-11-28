package com.lovego.mcool.di.module;

import com.lovego.mcool.MyApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lgs on 2018/11/22.
 */
@Module
public class AppModule {
    private MyApplication application;
    public AppModule(MyApplication application) {
        this.application = application;
    }
}
