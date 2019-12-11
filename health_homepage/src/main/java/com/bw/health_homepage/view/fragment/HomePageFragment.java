package com.bw.health_homepage.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.health_homepage.R;
import com.bw.health_homepage.view.activity.BannerWebViewMainActivity;
import com.bw.health_homepage.view.activity.HomePage_SearchActivity;
import com.bw.health_homepage.view.activity.MineActivity;
import com.bw.health_homepage.view.adapter.HomePageConsultAdapter;
import com.bw.health_homepage.view.adapter.HomePageConsultListAdapter;
import com.bw.health_homepage.view.adapter.HomePageOfficeAdapter;
import com.bw.health_knowledge.activity.Knowledge_Activity;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.wd.mvp.model.bean.BannerBean;
import com.wd.mvp.model.bean.ConsultBean;
import com.wd.mvp.model.bean.ConsultListBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.presenter.HomePagePresenter;
import com.wd.mvp.view.interfaces.IContractView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageFragment extends Fragment implements IContractView.iHomePageView {

    private XBanner banner;
    private ImageView home_page_disease;
    private ImageView home_page_drug;
    private RecyclerView home_page_recycle;
    private HomePagePresenter homePagePresenter;
    private HomePageOfficeAdapter homePageOfficeAdapter;
    private List<OfficeBean.ResultBean> result;
    private List<BannerBean.ResultBean> images;
    private List<ConsultBean.ResultBean> consultResult;
    private HomePageConsultAdapter homePageConsultAdapter;
    private RecyclerView home_page_consult_recycle;
    private RecyclerView home_page_consult_recycle2;
    private List<ConsultListBean.ResultBean> consultListResult;
    private HomePageConsultListAdapter homePageConsultListAdapter;
    private int count = 5;
    private int page = 1;
    private int id;
    private TextView home_search;
    private TextView chakan_gengduo;
    private ImageView boy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.health_homepage, container, false);
        banner = inflate.findViewById(R.id.banner);
        home_page_disease = inflate.findViewById(R.id.home_page_disease);
        home_page_drug = inflate.findViewById(R.id.home_page_drug);
        home_page_recycle = inflate.findViewById(R.id.home_page_recycle);
        home_page_consult_recycle = inflate.findViewById(R.id.home_page_consult_recycle);
        home_page_consult_recycle2 = inflate.findViewById(R.id.home_page_consult_recycle2);
        home_search = inflate.findViewById(R.id.home_search);
        boy = inflate.findViewById(R.id.boy);
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MineActivity.class));
            }
        });
        chakan_gengduo = inflate.findViewById(R.id.chakan_gengduo);
        homePagePresenter = new HomePagePresenter();
        homePagePresenter.attach(this);
        homePagePresenter.getBanner();
        homePagePresenter.getZixun();
        homePagePresenter.getConsult();
        homePagePresenter.getConsultList(1,1,5);
        home_page_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Knowledge_Activity.class));
            }
        });
        home_page_drug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Knowledge_Activity.class));
            }
        });
        home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomePage_SearchActivity.class));
            }
        });
        return inflate;


    }

    //问诊咨询
    @Override
    public void iOfficeSuccess(OfficeBean officeBean) {
        result = officeBean.getResult();
        homePageOfficeAdapter = new HomePageOfficeAdapter(getActivity(), result);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        home_page_recycle.setLayoutManager(gridLayoutManager);
        home_page_recycle.setAdapter(homePageOfficeAdapter);
    }
    //轮播
    @Override
    public void iBannerSuccess(BannerBean bannerBean) {
        images = bannerBean.getResult();
        banner.setData(images, null);
        banner.setPageChangeDuration(2000);
        banner.setPageTransformer(Transformer.Default);
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(images.get(position).getImageUrl()).into((ImageView) view);
            }
        });
        banner.startAutoPlay();
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                String jumpUrl = images.get(position).getJumpUrl();
                Intent intent = new Intent(getContext(), BannerWebViewMainActivity.class);
                intent.putExtra("jumpUrl",jumpUrl);
                startActivity(intent);
            }
        });
    }
    //健康咨询
    @Override
    public void iConsultSuccess(ConsultBean consultBean) {
        consultResult = consultBean.getResult();
        homePageConsultAdapter = new HomePageConsultAdapter(getActivity(), consultResult);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        home_page_consult_recycle.setLayoutManager(linearLayoutManager);
        home_page_consult_recycle.setAdapter(homePageConsultAdapter);
        homePageConsultAdapter.onItemClickListener(new HomePageConsultAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = consultResult.get(position).getId();
                homePagePresenter.getConsultList(id,1,5);
            }
        });
    }
    //健康咨询列表
    @Override
    public void iConsultListSuccess(ConsultListBean consultListBean) {
        consultListResult = consultListBean.getResult();
        homePageConsultListAdapter = new HomePageConsultListAdapter(getActivity(),consultListResult);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        home_page_consult_recycle2.setLayoutManager(linearLayoutManager);
        home_page_consult_recycle2.setAdapter(homePageConsultListAdapter);
    }

}
