package com.lovego.mcool.base;

/**
 * Created by lgs on 2018/11/13.
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T baseView);

    void detachView();
}
