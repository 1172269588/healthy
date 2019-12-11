package com.bw.health_bootpage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.bw.health_bootpage.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartUpPageActivity extends AppCompatActivity {

    private SharedPreferences pref;
    //用于判断是否是第一次运行，运行后变为false
    private boolean isFirst = true;
    private Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startuppage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //创建SharedPreferences对象
                pref = getSharedPreferences("isFirst", MODE_PRIVATE);
                StartUpPageActivity.this.isFirst = pref.getBoolean("isFirstIn", true);//如果第一次运行，无isFirstIn值，自动获取第二个参数为默认值
                if (StartUpPageActivity.this.isFirst) {//如果为true，进入if语句
                    intent = new Intent(StartUpPageActivity.this,BootPageActivity.class);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("isFirstIn", false);//保存isFirstIn值为false
                    editor.commit();//提交数据
                    startActivity(StartUpPageActivity.this.intent);
                    finish();
            }else {
                    startActivity(new Intent(StartUpPageActivity.this, BootPageActivity.class));
                    finish();
                }
                }
        },3000);
        }
    }
