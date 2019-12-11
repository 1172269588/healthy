package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.LoginBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class LoginPresenter extends BasePresenter<IContractView.iLoginView> {

    public void login(String email, String s) {
        OkHttpUtils.getInstance().getLogin(new OkHttpUtils.IOkCallBack<LoginBean>() {
            @Override
            public void callSuccess(LoginBean bean) {
                getV().iLoginSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },LoginBean.class,email,s);
    }
}
