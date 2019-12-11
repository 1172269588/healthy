package com.bw.health_homepage.view.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.health_homepage.R;
import com.bw.health_homepage.view.adapter.HomePageFragmentAdapter;
import com.bw.health_homepage.view.fragment.CircleFragment;
import com.bw.health_homepage.view.fragment.HomePageFragment;
import com.bw.health_homepage.view.fragment.VideoFragment;
import com.wd.mvp.presenter.HomeFragmentPresenter;
import com.wd.mvp.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MyActivity extends BaseActivity<HomeFragmentPresenter> {


    private RadioButton rb_main_homepage;
    private RadioGroup rg_main_radioGroup;
    private RadioButton rb_main_circle;
    private RadioButton rb_main_video;
    private List<Fragment> fragments;
    private ViewPager vp;
    private HomePageFragmentAdapter homePageFragmentAdapter;

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add(new CircleFragment());
        fragments.add(new VideoFragment());
        homePageFragmentAdapter = new HomePageFragmentAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(homePageFragmentAdapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rg_main_radioGroup.check(R.id.rb_main_homepage);
                        break;
                    case 1:
                        rg_main_radioGroup.check(R.id.rb_main_circle);
                        break;
                    case 2:
                        rg_main_radioGroup.check(R.id.rb_main_video);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg_main_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_main_homepage) {
                    vp.setCurrentItem(0);
                } else if (checkedId == R.id.rb_main_circle) {
                    vp.setCurrentItem(1);
                } else if (checkedId == R.id.rb_main_video) {
                    vp.setCurrentItem(2);
                }
            }
        });
    }

    @Override
    protected HomeFragmentPresenter setPresenter() {
        return new HomeFragmentPresenter();
    }


    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg_main_radioGroup = findViewById(R.id.rg_main_radioGroup);
        rb_main_homepage = findViewById(R.id.rb_main_homepage);
        rb_main_circle = findViewById(R.id.rb_main_circle);
        rb_main_video = findViewById(R.id.rb_main_video);
    }

    @Override
    protected int initLayout() {
        return R.layout.my_activity;
    }


}
