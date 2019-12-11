package com.bw.health_homepage.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.health_homepage.R;
import com.bw.health_setup.activity.Set_Up_Activity;
import com.wd.mvp.model.bean.UserInfoBean;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MineActivity extends AppCompatActivity {


    //头像
    private ImageView mine_activity_iv_user_head_pic;
    private LinearLayout patient_relative_titlebar;
    private TextView mine_activity_tv_nick_name;
    private TextView mine_activity_btn_sign_in;
    private Button mine_activity_btn_login;
    //设置
    private ImageView mine_activity_iv_set_up;
    private LinearLayout mine_activity_linear_my_money;
    private ImageView current;
    private ImageView history;
    private ImageView file;
    private ImageView mine_activity_iv_my_task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        initView();
        EventBus.getDefault().register(this);
        mine_activity_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MineActivity.this, LoginActivity.class));
            }
        });
        mine_activity_iv_set_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MineActivity.this, Set_Up_Activity.class));
            }
        });
    }

    private void initView() {
        mine_activity_iv_user_head_pic = findViewById(R.id.mine_activity_iv_user_head_pic);
        mine_activity_iv_my_task =  findViewById(R.id.mine_activity_iv_my_task);
        mine_activity_iv_set_up =  findViewById(R.id.mine_activity_iv_set_up);
        mine_activity_btn_login = findViewById(R.id.mine_activity_btn_login);
        patient_relative_titlebar = findViewById(R.id.patient_relative_titlebar);
        mine_activity_linear_my_money = findViewById(R.id.mine_activity_linear_my_money);
        mine_activity_tv_nick_name =  findViewById(R.id.mine_activity_tv_nick_name);
        mine_activity_btn_sign_in =  findViewById(R.id.mine_activity_btn_sign_in);
        current = findViewById(R.id.current);
        history =findViewById(R.id.history);
        file = findViewById(R.id.file);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void Message(UserInfoBean userInfoBean) {
        String headPic = userInfoBean.getHeadPic();
        String nickName = userInfoBean.getNickName();
        String userSignIn = userInfoBean.getUserSignIn();
        if (nickName.equals("")) {
            mine_activity_tv_nick_name.setText("猪小妹");
        }else {
            mine_activity_tv_nick_name.setText(nickName);
        }
        Glide.with(this).load(headPic)
                .transform(new CircleCrop())
                .placeholder(R.drawable.dermatology)
                .error(R.drawable.dermatology)
                .into(mine_activity_iv_user_head_pic);

        if (userSignIn.equals("签到")){
            mine_activity_btn_login.setVisibility(View.GONE);
            mine_activity_btn_sign_in.setVisibility(View.VISIBLE);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
