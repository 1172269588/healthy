package com.bw.health_knowledge.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.health_knowledge.R;
import com.bw.health_knowledge.activity.Disease_Activity;
import com.bw.health_knowledge.adapter.DiseaseOfficeAdapter;
import com.bw.health_knowledge.adapter.FindDiseaseAdapter;
import com.wd.mvp.model.bean.FindDiseaseBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.presenter.DiseasePresenter;
import com.wd.mvp.view.interfaces.IContractView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DiseaseFragment extends Fragment implements IContractView.iDiseaseView {

    private RecyclerView department_recycle;
    private RecyclerView disease_recycle;
    private DiseasePresenter diseasePresenter;
    private List<OfficeBean.ResultBean> officeResult;
    private DiseaseOfficeAdapter diseaseOfficeAdapter;
    private List<FindDiseaseBean.ResultBean> findDiseaseResult;
    private FindDiseaseAdapter findDiseaseAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_disease, container, false);
        department_recycle = inflate.findViewById(R.id.department_recycle);
        disease_recycle = inflate.findViewById(R.id.disease_recycle);
        diseasePresenter = new DiseasePresenter();
        diseasePresenter.attach(this);
        diseasePresenter.getiOffice();
        diseasePresenter.getDisease(2);
        return inflate;
    }

    @Override
    public void iOffice(OfficeBean officeBean) {
        officeResult = officeBean.getResult();
        diseaseOfficeAdapter = new DiseaseOfficeAdapter(getActivity(),officeResult);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        department_recycle.setLayoutManager(linearLayoutManager);
        department_recycle.setAdapter(diseaseOfficeAdapter);
        diseaseOfficeAdapter.onItemClickListener(new DiseaseOfficeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = officeResult.get(position).getId();
                diseasePresenter.getDisease(id);
            }
        });
    }

    @Override
    public void iDiseaseSuccess(final FindDiseaseBean findDiseaseBean) {
        findDiseaseResult = findDiseaseBean.getResult();
        findDiseaseAdapter = new FindDiseaseAdapter(getActivity(),findDiseaseResult);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        disease_recycle.setLayoutManager(gridLayoutManager);
        disease_recycle.setAdapter(findDiseaseAdapter);
        findDiseaseAdapter.onItemClickListener(new FindDiseaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = findDiseaseBean.getResult().get(position).getId();
                String name = findDiseaseBean.getResult().get(position).getName();
                Intent intent = new Intent(getActivity(), Disease_Activity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

    }
}
