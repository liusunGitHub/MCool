package com.lovego.mcool.model.http;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by lgs on 2018/11/30.
 */
public class RetrofitHelper implements HttpHelper{
    private HttpApi httpApi;

    @Inject
    RetrofitHelper(HttpApi httpApi) {
        this.httpApi = httpApi;
    }

    @Override
    public Flowable<BaseHttpResult> loginCode(String phone) {
        return httpApi.loginCode(phone);
    }
}

