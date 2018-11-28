package com.lovego.mcool.base;

import javax.inject.Inject;

/**
 * Created by lgs on 2018/11/13.
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity {
    @Inject
    protected T basePresenter;

    @Override
    protected void initView() {
        super.initView();
        initInject();
        if (null != basePresenter) {
            basePresenter.attachView(this);
        }
    }

    protected abstract void initInject();

    @Override
    protected void onDestroy() {
        if (null != basePresenter) {
            basePresenter.detachView();
            basePresenter = null;
        }
        super.onDestroy();
    }
}

