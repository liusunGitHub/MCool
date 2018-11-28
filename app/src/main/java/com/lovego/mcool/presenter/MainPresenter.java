package com.lovego.mcool.presenter;

import com.lovego.mcool.base.BaseMvpPresenter;
import com.lovego.mcool.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by lgs on 2018/11/28.
 */
public class MainPresenter extends BaseMvpPresenter<MainContract.IView>
        implements MainContract.Presenter {
    @Inject
    MainPresenter() {
    }

    @Override
    public void load() {
        baseView.showToastMsg("加载数据");
    }
}
