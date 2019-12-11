package com.bw.health_homepage.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.health_homepage.R;
import com.wd.mvp.RsaCoder;
import com.wd.mvp.model.bean.LoginBean;
import com.wd.mvp.model.bean.UserInfoBean;
import com.wd.mvp.presenter.LoginPresenter;
import com.wd.mvp.view.activity.BaseActivity;
import com.wd.mvp.view.interfaces.IContractView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class
LoginActivity extends BaseActivity<LoginPresenter> implements IContractView.iLoginView  {
    private EditText login_activity_et_email;
    private EditText login_activity_et_pwd;
    private Button login_activity_btn_login;
    private ImageView login_activity_iv_hidden_pwd;
    private ImageView login_activity_iv_show_pwd;
    private TextView login_activity_tv_forget_pwd;
    private TextView login_activity_tv_register;

    @Override
    protected void initData() {
        login_activity_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_activity_et_email.getText().toString().trim();
                String pwd = login_activity_et_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this, "邮箱,密码不能为空!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    String s = RsaCoder.encryptByPublicKey(pwd);
                    p.login(email,s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        login_activity_iv_hidden_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果选中，显示密码
                login_activity_et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                login_activity_iv_show_pwd.setVisibility(View.VISIBLE);
                login_activity_iv_hidden_pwd.setVisibility(View.GONE);
            }
        });

        login_activity_iv_show_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_activity_et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                login_activity_iv_show_pwd.setVisibility(View.GONE);
                login_activity_iv_hidden_pwd.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        login_activity_et_email = findViewById(R.id.login_activity_et_email);
        login_activity_et_pwd = findViewById(R.id.login_activity_et_pwd);
        login_activity_btn_login = findViewById(R.id.login_activity_btn_login);
        login_activity_iv_hidden_pwd = findViewById(R.id.login_activity_iv_hidden_pwd);
        login_activity_iv_show_pwd = findViewById(R.id.login_activity_iv_show_pwd);
        login_activity_tv_forget_pwd = findViewById(R.id.login_activity_tv_forget_pwd);
        login_activity_tv_register = findViewById(R.id.login_activity_tv_register);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)

    public void onMessageEvent(Object myEvent) {

    }
    @Override
    protected int initLayout() {
        return R.layout.login_activity;
    }


    @Override
    public void iLoginSuccess(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")){
            Toast.makeText(this,loginBean.getMessage(), Toast.LENGTH_SHORT).show();

            LoginBean.ResultBean loginResult = loginBean.getResult();
            //用户年龄
            int age = loginResult.getAge();
            //用户身高
            int height = loginResult.getHeight();
            //用户userId
            int id = loginResult.getId();
            //用户sessionId
            String sessionId = loginResult.getSessionId();
            //性别
            int sex = loginResult.getSex();
            //用户邮箱
            String email = loginResult.getEmail();
            //极光密码
            String jiGuangPwd = loginResult.getJiGuangPwd();
            //昵称
            String nickName = loginResult.getNickName();
            //用户名
            String userName = loginResult.getUserName();
            //体重
            int weight = loginResult.getWeight();
            //头像
            String headPic = loginResult.getHeadPic();
            //是否绑定微信
            int whetherBingWeChat = loginResult.getWhetherBingWeChat();
            EventBus.getDefault().postSticky(new UserInfoBean(age,height,id,sessionId,sex,email,jiGuangPwd,nickName,userName,weight,headPic,whetherBingWeChat));
            startActivity(new Intent(LoginActivity.this,MineActivity.class));
            finish();
        }else {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
