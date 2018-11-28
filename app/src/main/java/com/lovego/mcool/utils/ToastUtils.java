package com.lovego.mcool.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.lovego.mcool.MyApplication;

/**
 * Created by lgs on 2018/11/12.
 * 使用静态内部类，单例模式
 */
public class ToastUtils {
    private static Toast mToast = null;

    private ToastUtils() {
        initToast();
    }

    private static void initToast() {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }
    }

    private static class ToastUtilsHolder {
        private static final ToastUtils INSTANCE = new ToastUtils();
    }

    public static final ToastUtils getInstance() {
        return ToastUtilsHolder.INSTANCE;
    }

    public void showMsg(String msg) {
        if (null == mToast) {
            initToast();
        }
        mToast.setText(msg);
        mToast.show();
    }

    public void showMsg(@StringRes int msg) {
        if (null == mToast) {
            initToast();
        }
        mToast.setText(msg);
        mToast.show();
    }


}
