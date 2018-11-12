package com.lovego.mcool;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lgs on 2018/11/12.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication = null;

    public static MyApplication getApplication() {
        return myApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication  = this;
        initLeakCanary();
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
