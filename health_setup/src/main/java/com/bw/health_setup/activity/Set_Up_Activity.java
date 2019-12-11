package com.bw.health_setup.activity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.health_setup.R;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Set_Up_Activity extends AppCompatActivity {

    private Button set_up_activity_btn_quit_landing;
    private ImageView set_up_activity_iv_change_pssword;
    private ImageView set_up_activity_iv_headPic;
    private ImageView set_up_activity_iv_screen_brightness;
    private RelativeLayout set_up_activity_relative_my_message;
    private TextView set_up_activity_tv_nickName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        set_up_activity_btn_quit_landing = findViewById(R.id.set_up_activity_btn_quit_landing);
        set_up_activity_iv_change_pssword = findViewById(R.id.set_up_activity_iv_change_pssword);
        set_up_activity_iv_headPic = findViewById(R.id.set_up_activity_iv_headPic);
        set_up_activity_iv_screen_brightness = findViewById(R.id.set_up_activity_iv_screen_brightness);
        set_up_activity_relative_my_message = findViewById(R.id.set_up_activity_relative_my_message);
        set_up_activity_tv_nickName =  findViewById(R.id.set_up_activity_tv_nickName);
    }
}
