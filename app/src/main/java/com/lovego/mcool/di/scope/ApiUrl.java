package com.lovego.mcool.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Created by lgs on 2018/11/30.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiUrl {
}
