package com.lovego.mcool.model.http;

/**
 * Created by lgs on 2018/11/30.
 */
public class HttpResult<T> {
    private T data;
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public T getData() {
        return data;
    }
}
