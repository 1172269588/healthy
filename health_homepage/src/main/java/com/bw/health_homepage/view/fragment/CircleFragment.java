package com.bw.health_homepage.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.health_homepage.R;
import com.bw.health_homepage.view.adapter.CircleAdapter;
import com.bw.health_homepage.view.adapter.CircleRoomAdapter;
import com.wd.mvp.model.bean.CircleBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.presenter.CirclePresenter;
import com.wd.mvp.view.interfaces.IContractView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CircleFragment extends Fragment implements IContractView.iCircleView {

    private RecyclerView circle_recycle1;
    private RecyclerView circle_recycle2;
    private List<OfficeBean.ResultBean> result;
    private CirclePresenter circlePresenter;
    private int id;
    private int page = 2;
    private int count =5;
    private CircleRoomAdapter circleRoomAdapter;
    private List<CircleBean.ResultBean> result1;
    private CircleAdapter circleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_my, container, false);
        circle_recycle1 = inflate.findViewById(R.id.circle_recycle1);
        circle_recycle2 = inflate.findViewById(R.id.circle_recycle2);
        circlePresenter = new CirclePresenter();
        circlePresenter.attach(this);
        circlePresenter.getRoom();
        circlePresenter.getCircle(2,2,5);
        return inflate;
    }

    @Override
    public void iRoomSuccess(OfficeBean officeBean) {
        result = officeBean.getResult();
        circleRoomAdapter = new CircleRoomAdapter(getActivity(),result);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        circle_recycle1.setLayoutManager(linearLayoutManager);
        circle_recycle1.setAdapter(circleRoomAdapter);

        circleRoomAdapter.onItemClickListener(new CircleRoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = result.get(position).getId();
                circlePresenter.getCircle(id,page,count);
            }
        });
    }

    @Override
    public void iCircleSuccess(CircleBean circleBean) {
        result1 = circleBean.getResult();
        circleAdapter = new CircleAdapter(getActivity(),result1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        circle_recycle2.setLayoutManager(linearLayoutManager);
        circle_recycle2.setAdapter(circleAdapter);
    }
}
