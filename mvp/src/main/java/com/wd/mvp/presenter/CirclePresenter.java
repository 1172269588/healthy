package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.CircleBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class CirclePresenter extends BasePresenter<IContractView.iCircleView> {

    public void getCircle(int id, int page, int count) {
         OkHttpUtils.getInstance().getCircle(new OkHttpUtils.IOkCallBack<CircleBean>() {
             @Override
             public void callSuccess(CircleBean bean) {
                   getV().iCircleSuccess(bean);
             }

             @Override
             public void callError(String msg) {

             }
         },CircleBean.class,id,page,count);
    }

    public void getRoom() {
        OkHttpUtils.getInstance().getRoom(new OkHttpUtils.IOkCallBack<OfficeBean>() {
            @Override
            public void callSuccess(OfficeBean bean) {
                getV().iRoomSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },OfficeBean.class);
    }
}
