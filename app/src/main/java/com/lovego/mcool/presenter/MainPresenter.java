package com.lovego.mcool.presenter;

import com.lovego.mcool.MyApplication;
import com.lovego.mcool.base.BaseMvpPresenter;
import com.lovego.mcool.contract.MainContract;
import com.lovego.mcool.model.http.BaseHttpResult;
import com.lovego.mcool.model.http.DataHelper;
import com.lovego.mcool.model.http.MySubscriber;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lgs on 2018/11/28.
 */
public class MainPresenter extends BaseMvpPresenter<MainContract.IView>
        implements MainContract.Presenter {
    private DataHelper dataHelper;
    @Inject
    MainPresenter() {
        dataHelper = MyApplication.getAppComponent().getDataHelper();
    }

    @Override
    public void loadData() {
        addSubscribe(dataHelper.loginCode("134xxxxxxxx")
                .compose(MyRxUtils.toMain(Schedulers.io()))
                .subscribeWith(new MySubscriber<BaseHttpResult>(baseView, true) {
                    @Override
                    public void onNext(BaseHttpResult httpNoResult) {

                    }
                }));

//    baseView.showTipMsg("加载数据");
    }
}
