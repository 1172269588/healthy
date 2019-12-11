package com.bw.health_homepage.view.adapter;

import com.bw.health_homepage.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.mvp.model.bean.SearchBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoctorSearchVoListAdapter extends BaseQuickAdapter<SearchBean.ResultBean.DoctorSearchVoListBean, BaseViewHolder> {

    public DoctorSearchVoListAdapter(int layoutResId, List<SearchBean.ResultBean.DoctorSearchVoListBean> doctorSearchVoList) {
        super(layoutResId, doctorSearchVoList);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.ResultBean.DoctorSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name, item.getDoctorName());
    }

}
