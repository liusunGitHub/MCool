package com.lovego.mcool.model.http;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lgs on 2018/11/30.
 */
public interface HttpApi {
    /**
     * 登录时获取验证码.
     *
     * @param phone 手机号
     * @return {"code":0}
     */
    @FormUrlEncoded
    @POST(ProtocolHttp.URL_LOGIN_CODE)
    Flowable<BaseHttpResult> loginCode(@Field("phone") String phone);
}

