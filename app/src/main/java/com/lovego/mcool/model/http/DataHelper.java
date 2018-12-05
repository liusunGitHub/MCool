package com.lovego.mcool.model.http;

import io.reactivex.Flowable;

/**
 * Created by lgs on 2018/11/30.
 */
public class DataHelper implements HttpHelper {
    private HttpHelper http;

    public DataHelper(HttpHelper http) {
        this.http = http;
    }

    @Override
    public Flowable<BaseHttpResult> loginCode(String phone) {
        return http.loginCode(phone);
    }
}

