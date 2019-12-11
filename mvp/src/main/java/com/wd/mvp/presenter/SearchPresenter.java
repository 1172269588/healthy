package com.wd.mvp.presenter;

import com.wd.mvp.model.bean.HotSearchBean;
import com.wd.mvp.model.bean.SearchBean;
import com.wd.mvp.model.http.OkHttpUtils;
import com.wd.mvp.view.interfaces.IContractView;

public class SearchPresenter extends BasePresenter<IContractView.iSearchView> {

    public void getHomePagerSearch(String keyWord) {
        OkHttpUtils.getInstance().getHomePagerSearch(new OkHttpUtils.IOkCallBack<SearchBean>() {
            @Override
            public void callSuccess(SearchBean bean) {
                getV().iSearchSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, SearchBean.class,keyWord);
    }

    public void getHomeHotSearch() {
        OkHttpUtils.getInstance().getHomeHotSearch(new OkHttpUtils.IOkCallBack<HotSearchBean>() {
            @Override
            public void callSuccess(HotSearchBean bean) {
                getV().iHotSearchSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },HotSearchBean.class);
    }
}
