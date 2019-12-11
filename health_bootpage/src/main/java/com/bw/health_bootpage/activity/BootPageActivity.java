package com.bw.health_bootpage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.health_bootpage.R;
import com.bw.health_bootpage.adapter.BootPageAdapter;
import com.bw.health_bootpage.fragment.BootPageFragmentFive;
import com.bw.health_bootpage.fragment.BootPageFragmentFour;
import com.bw.health_bootpage.fragment.BootPageFragmentOne;
import com.bw.health_bootpage.fragment.BootPageFragmentThree;
import com.bw.health_bootpage.fragment.BootPageFragmentTwo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class BootPageActivity extends AppCompatActivity {

    private List<Fragment> fraglist;
    private ViewPager boot_page_viewpager;
    private RadioGroup boot_page_rg;
    private RadioButton boot_page_rb1;
    private RadioButton boot_page_rb2;
    private RadioButton boot_page_rb3;
    private RadioButton boot_page_rb4;
    private RadioButton boot_page_rb5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootpage);
        initView();
        fraglist = new ArrayList<>();
        fraglist.add(new BootPageFragmentOne());
        fraglist.add(new BootPageFragmentTwo());
        fraglist.add(new BootPageFragmentThree());
        fraglist.add(new BootPageFragmentFour());
        fraglist.add(new BootPageFragmentFive());

        BootPageAdapter bootPageAdapter = new BootPageAdapter(getSupportFragmentManager(),fraglist);
        boot_page_viewpager.setAdapter(bootPageAdapter);

        boot_page_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               switch (position){
                   case 0:
                       boot_page_rg.check(R.id.boot_page_rb1);
                       break;
                   case 1:
                       boot_page_rg.check(R.id.boot_page_rb2);
                       break;
                   case 2:
                       boot_page_rg.check(R.id.boot_page_rb3);
                       break;
                   case 3:
                       boot_page_rg.check(R.id.boot_page_rb4);
                       break;
                   case 4:
                       boot_page_rg.check(R.id.boot_page_rb5);
                       break;
               }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        boot_page_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.boot_page_rb1){
                    boot_page_viewpager.setCurrentItem(0);
                }else if (checkedId == R.id.boot_page_rb2){
                    boot_page_viewpager.setCurrentItem(1);
                }else if (checkedId == R.id.boot_page_rb3){
                    boot_page_viewpager.setCurrentItem(2);
                }else if (checkedId == R.id.boot_page_rb4){
                    boot_page_viewpager.setCurrentItem(3);
                }else if (checkedId == R.id.boot_page_rb5){
                    boot_page_viewpager.setCurrentItem(4);
                }
            }
        });
    }

    private void initView() {
        boot_page_viewpager = findViewById(R.id.boot_page_viewpager);
        boot_page_rg = findViewById(R.id.boot_page_rg);
        boot_page_rb1 = findViewById(R.id.boot_page_rb1);
        boot_page_rb2 = findViewById(R.id.boot_page_rb2);
        boot_page_rb3 = findViewById(R.id.boot_page_rb3);
        boot_page_rb4 = findViewById(R.id.boot_page_rb4);
        boot_page_rb5 = findViewById(R.id.boot_page_rb5);
    }
}
