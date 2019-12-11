package com.bw.health_homepage.view.adapter;

import com.bw.health_homepage.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.mvp.model.bean.SearchBean;

import java.util.List;

import androidx.annotation.Nullable;

public class DrugsSearchVoListAdapter extends BaseQuickAdapter<SearchBean.ResultBean.DrugsSearchVoListBean, BaseViewHolder> {
    public DrugsSearchVoListAdapter(int layoutResId, @Nullable List<SearchBean.ResultBean.DrugsSearchVoListBean> drugsSearchVoList) {
        super(layoutResId, drugsSearchVoList);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.ResultBean.DrugsSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name,item.getDrugsName());
    }
}
