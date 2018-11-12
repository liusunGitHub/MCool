package com.lovego.mcool;

import android.os.Bundle;

import com.lovego.mcool.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        initHeader(true, false, null).setHeaderTitle("首页");
        showToastMsg("我是首页");

    }
}
