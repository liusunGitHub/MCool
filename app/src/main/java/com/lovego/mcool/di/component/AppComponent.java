package com.lovego.mcool.di.component;

import com.lovego.mcool.di.module.AppModule;
import com.lovego.mcool.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lgs on 2018/11/22.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
}
