package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.DrugDetailsBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class DrugDetailsPresenter extends BasePresenter<IContractView.iDrugDetailsView> {

    public void drugDetails(int id) {
        OkHttpUtils.getInstance().getDrugDetails(new OkHttpUtils.IOkCallBack<DrugDetailsBean>() {
            @Override
            public void callSuccess(DrugDetailsBean bean) {
                getV().iDrugDetailsSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },DrugDetailsBean.class,id);
    }
}
