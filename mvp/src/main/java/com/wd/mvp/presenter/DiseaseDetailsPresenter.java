package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.DiseaseDetailsBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class DiseaseDetailsPresenter extends BasePresenter<IContractView.iDiseaseDetailsView> {

    public void diseaseDetails(int id) {
        OkHttpUtils.getInstance().getDiseaseDetails(new OkHttpUtils.IOkCallBack<DiseaseDetailsBean>() {
            @Override
            public void callSuccess(DiseaseDetailsBean bean) {
                getV().iDisDetailsSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },DiseaseDetailsBean.class,id);
    }
}
