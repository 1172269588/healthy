package com.bw.health_knowledge.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.health_knowledge.R;
import com.bw.health_knowledge.activity.Disease_Activity;
import com.bw.health_knowledge.activity.Drug_Activity;
import com.bw.health_knowledge.adapter.DrugOfficeAdapter;
import com.bw.health_knowledge.adapter.FindDrugAdapter;
import com.wd.mvp.model.bean.DrugBean;
import com.wd.mvp.model.bean.FindDrugBean;
import com.wd.mvp.presenter.DrugPresenter;
import com.wd.mvp.view.interfaces.IContractView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrugFragment extends Fragment implements IContractView.iDrugView {

    private RecyclerView drug_recycle;
    private RecyclerView department2_recycle;
    private DrugPresenter drugPresenter;
    private int page =1;
    private int count =12;
    private int drugsCategoryId;
    private List<DrugBean.ResultBean> drugResult;
    private DrugOfficeAdapter drugOfficeAdapter;
    private List<FindDrugBean.ResultBean> findDrugResult;
    private FindDrugAdapter findDrugAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_drug, container, false);
        department2_recycle = inflate.findViewById(R.id.department2_recycle);
        drug_recycle = inflate.findViewById(R.id.drug_recycle);
        drugPresenter = new DrugPresenter();
        drugPresenter.attach(this);
        drugPresenter.getiDrug();
        drugPresenter.getDrug(1,1,12);
        return inflate;
    }

    @Override
    public void iDrug(DrugBean drugBean) {
        drugResult = drugBean.getResult();
        drugOfficeAdapter = new DrugOfficeAdapter(getActivity(),drugResult);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        department2_recycle.setLayoutManager(linearLayoutManager);
        department2_recycle.setAdapter(drugOfficeAdapter);

        drugOfficeAdapter.onItemClickListener(new DrugOfficeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = drugResult.get(position).getId();
                drugPresenter.getDrug(id,1,12);
            }
        });
    }

    @Override
    public void iDrugSuccess(final FindDrugBean findDrugBean) {
        findDrugResult = findDrugBean.getResult();
        findDrugAdapter = new FindDrugAdapter(getActivity(),findDrugResult);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        drug_recycle.setLayoutManager(gridLayoutManager);
        drug_recycle.setAdapter(findDrugAdapter);
        findDrugAdapter.onItemClickListener(new FindDrugAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = findDrugBean.getResult().get(position).getId();
                String name = findDrugBean.getResult().get(position).getName();
                Intent intent = new Intent(getActivity(), Drug_Activity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
