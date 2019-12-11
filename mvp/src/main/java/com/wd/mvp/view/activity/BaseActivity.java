package com.wd.mvp.view.activity;

import android.os.Bundle;

import com.wd.mvp.presenter.BasePresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * date:2019/12/4
 * author:郑宏宇(Msi)
 * function:
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity {

    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        p = setPresenter();
        p.attach(this);
        initData();
    }

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.detach();
    }
}
