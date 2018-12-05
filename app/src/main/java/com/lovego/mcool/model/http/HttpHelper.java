package com.lovego.mcool.model.http;

import io.reactivex.Flowable;

/**
 * Created by lgs on 2018/11/30.
 */
public interface HttpHelper {
    /**
     * 登录时获取验证码.
     *
     * @param phone 手机号
     * @return {"code":0}
     */
    Flowable<BaseHttpResult> loginCode(String phone);
  /*Flowable<HttpResult<Login>> login(String phone, String code);
  Flowable<HttpResult<List<DiyBean>>> diyKeys(String allId);*/

}
