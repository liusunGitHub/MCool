package com.lovego.mcool;

import android.app.Application;

import com.lovego.mcool.di.component.AppComponent;
import com.lovego.mcool.di.component.DaggerAppComponent;
import com.lovego.mcool.di.module.AppModule;
import com.lovego.mcool.di.module.HttpModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lgs on 2018/11/12.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;
    private static AppComponent appComponent;



    public static MyApplication getInstance() {
        return myApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication  = this;
        initLeakCanary();
    }

    /**
     * 获取AppComponent.
     *
     * @return AppComponent
     */
    public static synchronized AppComponent getAppComponent() {
        if (null == appComponent) {
             appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getInstance()))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }


    /**
     * 初始化内存检测工具
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

}
