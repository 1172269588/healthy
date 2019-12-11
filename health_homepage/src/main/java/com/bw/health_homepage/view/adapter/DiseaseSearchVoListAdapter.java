package com.bw.health_homepage.view.adapter;

import com.bw.health_homepage.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.mvp.model.bean.SearchBean;

import java.util.List;


public class DiseaseSearchVoListAdapter extends BaseQuickAdapter<SearchBean.ResultBean.DiseaseSearchVoListBean, BaseViewHolder> {


    public DiseaseSearchVoListAdapter(int layoutResId, List<SearchBean.ResultBean.DiseaseSearchVoListBean> diseaseSearchVoList) {
        super(layoutResId, diseaseSearchVoList);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.ResultBean.DiseaseSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name,item.getDiseaseName());
    }


}