package com.lovego.mcool;

import android.os.Bundle;

import com.lovego.mcool.base.BaseMvpActivity;
import com.lovego.mcool.contract.MainContract;
import com.lovego.mcool.presenter.MainPresenter;



public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IView {
    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        initHeader(true, false, null).setHeaderTitle("首页");
        basePresenter.load();
//        showToastMsg("我是首页"+myApplication);

    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
