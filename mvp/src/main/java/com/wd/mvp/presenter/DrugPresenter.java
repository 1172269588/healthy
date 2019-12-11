package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.DrugBean;
import com.wd.mvp.model.bean.FindDrugBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class DrugPresenter extends BasePresenter<IContractView.iDrugView> {

    public void getiDrug() {
        OkHttpUtils.getInstance().getiDrug(new OkHttpUtils.IOkCallBack<DrugBean>() {
            @Override
            public void callSuccess(DrugBean bean) {
                 getV().iDrug(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },DrugBean.class);
    }

    public void getDrug(int drugsCategoryId, int page, int count) {
        OkHttpUtils.getInstance().getDrug(new OkHttpUtils.IOkCallBack<FindDrugBean>() {
            @Override
            public void callSuccess(FindDrugBean bean) {
                getV().iDrugSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },FindDrugBean.class,drugsCategoryId,page,count);
    }
}
