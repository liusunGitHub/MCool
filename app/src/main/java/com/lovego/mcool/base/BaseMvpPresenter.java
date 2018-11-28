package com.lovego.mcool.base;

/**
 * Created by lgs on 2018/11/13.
 */
public class BaseMvpPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T baseView;

    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        this.baseView = null;
    }
}
