package com.lovego.mcool.base;

import android.support.annotation.StringRes;

/**
 * Created by lgs on 2018/11/12.
 */
public interface BaseView {
    void showToastMsg(String msg);

    void showToastMsg(@StringRes int msg);

    void showLoading();

    void hideLoading();

    void invalidToken();

    void myFinish();
}
