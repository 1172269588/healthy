package com.bw.health_knowledge.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.health_knowledge.R;
import com.bw.health_knowledge.adapter.KnowledgeFragmentAdapter;
import com.bw.health_knowledge.fragment.DiseaseFragment;
import com.bw.health_knowledge.fragment.DrugFragment;
import com.wd.mvp.presenter.HomeFragmentPresenter;
import com.wd.mvp.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class Knowledge_Activity extends BaseActivity<HomeFragmentPresenter> {

    private List<Fragment> fragmentList;
    private KnowledgeFragmentAdapter knowledgeFragmentAdapter;
    private ImageView knowledge_iv;
    private RadioGroup details_rg;
    private RadioButton details_btn1;
    private RadioButton details_btn2;
    private ViewPager details_vp;

    @Override
    protected void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new DiseaseFragment());
        fragmentList.add(new DrugFragment());
        knowledgeFragmentAdapter = new KnowledgeFragmentAdapter(getSupportFragmentManager(),fragmentList);
        details_vp.setAdapter(knowledgeFragmentAdapter);

        details_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        details_rg.check(R.id.details_btn1);
                        details_btn1.setTextColor(Color.BLUE);
                        details_btn2.setTextColor(Color.GRAY);
                        break;
                    case 1:
                        details_rg.check(R.id.details_btn2);
                        details_btn1.setTextColor(Color.GRAY);
                        details_btn2.setTextColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        details_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.details_btn1) {
                    details_vp.setCurrentItem(0);
                } else if (checkedId == R.id.details_btn2) {
                    details_vp.setCurrentItem(1);
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
        knowledge_iv = findViewById(R.id.knowledge_iv);
        details_rg = findViewById(R.id.details_rg);
        details_btn1 = findViewById(R.id.details_btn1);
        details_btn2 = findViewById(R.id.details_btn2);
        details_vp = findViewById(R.id.details_vp);

    }

    @Override
    protected int initLayout() {
        return R.layout.knowledge_activity;
    }
}
