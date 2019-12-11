package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.BannerBean;
import com.wd.mvp.model.bean.ConsultBean;
import com.wd.mvp.model.bean.ConsultListBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class HomePagePresenter extends BasePresenter<IContractView.iHomePageView> {

    public void getBanner() {
        OkHttpUtils.getInstance().getBanner(new OkHttpUtils.IOkCallBack<BannerBean>() {
            @Override
            public void callSuccess(BannerBean bannerBean) {
                getV().iBannerSuccess(bannerBean);
            }

            @Override
            public void callError(String msg) {

            }
        },BannerBean.class);
    }

    public void getZixun() {
         OkHttpUtils.getInstance().getZixun(new OkHttpUtils.IOkCallBack<OfficeBean>() {
             @Override
             public void callSuccess(OfficeBean bean) {
                  getV().iOfficeSuccess(bean);
             }

             @Override
             public void callError(String msg) {

             }
         },OfficeBean.class);
    }

    public void getConsult() {
         OkHttpUtils.getInstance().getConsult(new OkHttpUtils.IOkCallBack<ConsultBean>() {
             @Override
             public void callSuccess(ConsultBean bean) {
                  getV().iConsultSuccess(bean);
             }

             @Override
             public void callError(String msg) {

             }
         },ConsultBean.class);
    }

    public void getConsultList(int plateId, int page, int count) {
         OkHttpUtils.getInstance().getConsultList(new OkHttpUtils.IOkCallBack<ConsultListBean>() {
             @Override
             public void callSuccess(ConsultListBean bean) {
                   getV().iConsultListSuccess(bean);
             }

             @Override
             public void callError(String msg) {

             }
         },ConsultListBean.class,plateId,page,count);
    }


}
