package com.lovego.mcool.di.module;

import com.lovego.mcool.MyApplication;
import com.lovego.mcool.model.http.DataHelper;
import com.lovego.mcool.model.http.HttpHelper;
import com.lovego.mcool.model.http.RetrofitHelper;

import javax.inject.Singleton;

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

    @Provides
    @Singleton
    DataHelper provideDataHelper(HttpHelper httpHelper) {
        return new DataHelper(httpHelper);
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

}
