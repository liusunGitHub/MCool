package com.lovego.mcool.contract;

import com.lovego.mcool.base.BasePresenter;
import com.lovego.mcool.base.BaseView;

/**
 * Created by lgs on 2018/11/22.
 */
public interface MainContract {
    interface IView extends BaseView {
    }

    interface Presenter extends BasePresenter<IView> {
        void loadData();
    }
}
