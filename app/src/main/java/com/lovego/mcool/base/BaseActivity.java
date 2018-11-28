package com.lovego.mcool.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lovego.mcool.MyApplication;
import com.lovego.mcool.R;
import com.lovego.mcool.di.component.ActivityComponent;
import com.lovego.mcool.di.component.DaggerActivityComponent;
import com.lovego.mcool.di.module.ActivityModule;
import com.lovego.mcool.utils.ToastUtils;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by lgs on 2018/11/12.
 */
public abstract class BaseActivity extends SupportActivity implements BaseView, View.OnClickListener {

    private ImageView ivBack;
    private TextView header_title;
    private FrameLayout header_right_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //强制竖屏(不强制加)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_base);
        FrameLayout contentLayout = findViewById(R.id.body_layout);
        ivBack = findViewById(R.id.header_left_back);
        header_title = findViewById(R.id.header_title);
        header_right_view = findViewById(R.id.header_right_view);
        int layoutId = getLayoutId(savedInstanceState);
        //没有布局的时候传0
        if (0 != layoutId) {
            View contentView = getLayoutInflater().inflate(layoutId, null);
            contentLayout.addView(contentView);
        }
        initView();
        initData();
        setOnClick(R.id.header_left_back);

        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }
    }

    /**
     * 初始化Header的内容
     *
     * @param isShowHeader 是否显示Header
     * @param isShowBack   是否显示左边的返回按钮
     * @param rightView    显示右边的View
     * @return 当前activity对象，可以连点
     */
    protected BaseActivity initHeader(boolean isShowHeader, boolean isShowBack,
                                      View rightView) {
        if (isShowHeader) {
            ivBack.setVisibility(isShowBack ? View.VISIBLE : View.INVISIBLE);
            header_title.setVisibility(View.VISIBLE);
            header_right_view.setVisibility(View.VISIBLE);
            if (rightView != null) {
                header_right_view.addView(rightView);
            }
        } else {
            ivBack.setVisibility(View.GONE);
            header_title.setVisibility(View.GONE);
            header_right_view.setVisibility(View.GONE);
        }
        return this;
    }


    /**
     * 设置点击事件.
     *
     * @param ids 被点击View的ID
     * @return {@link BaseActivity}
     */
    public BaseActivity setOnClick(@IdRes int... ids) {
        View view;
        for (int id : ids) {
            view = findViewById(id);
            if (null != view) {
                view.setOnClickListener(this);
            }
        }
        return this;
    }

    /**
     * 设置点击事件.
     *
     * @param views 被点击View
     * @return {@link BaseActivity}
     */
    public BaseActivity setOnClick(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
        return this;
    }

    protected abstract int getLayoutId(Bundle savedInstanceState);

    protected void initData() {
    }

    protected void initView() {
    }


    public BaseActivity setHeaderTitle(String title) {
        header_title.setText(title);
        return this;
    }

    public BaseActivity setHeaderTitle(@StringRes int stringId) {
        header_title.setText(stringId);
        return this;
    }


    @Override
    public void showToastMsg(String msg) {
        ToastUtils.getInstance().showMsg(msg);

    }

    @Override
    public void showToastMsg(int msg) {
        ToastUtils.getInstance().showMsg(msg);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void invalidToken() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header_left_back:
                onBackPressedSupport();
                break;
            default:
                break;
        }
    }


    /**
     * Finish当前页面，最好实现onBackPressedSupport()，这个方法会有一个退栈操作，
     * 开源框架实现的，我们不用管
     */
    @Override
    public void myFinish() {
        onBackPressedSupport();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(new ActivityModule())
                .build();
    }

}
