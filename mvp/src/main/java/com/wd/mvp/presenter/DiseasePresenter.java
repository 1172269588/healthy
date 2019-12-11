package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.FindDiseaseBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class DiseasePresenter extends BasePresenter<IContractView.iDiseaseView> {

    public void getiOffice() {
        OkHttpUtils.getInstance().getiOffice(new OkHttpUtils.IOkCallBack<OfficeBean>() {
            @Override
            public void callSuccess(OfficeBean bean) {
                  getV().iOffice(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },OfficeBean.class);
    }

    public void getDisease(int departmentId) {
         OkHttpUtils.getInstance().getDisease(new OkHttpUtils.IOkCallBack<FindDiseaseBean>() {
             @Override
             public void callSuccess(FindDiseaseBean bean) {
                   getV().iDiseaseSuccess(bean);
             }

             @Override
             public void callError(String msg) {

             }
         },FindDiseaseBean.class,departmentId);
    }
}
