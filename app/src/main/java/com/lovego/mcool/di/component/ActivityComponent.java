package com.lovego.mcool.di.component;

import com.lovego.mcool.MainActivity;
import com.lovego.mcool.di.module.ActivityModule;
import com.lovego.mcool.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by lgs on 2018/11/22.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
