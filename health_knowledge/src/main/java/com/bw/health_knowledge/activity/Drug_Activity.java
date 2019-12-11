package com.bw.health_knowledge.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.health_knowledge.R;
import com.wd.mvp.model.bean.DrugDetailsBean;
import com.wd.mvp.presenter.DrugDetailsPresenter;
import com.wd.mvp.view.activity.BaseActivity;
import com.wd.mvp.view.interfaces.IContractView;

public class Drug_Activity extends BaseActivity<DrugDetailsPresenter> implements IContractView.iDrugDetailsView {

    private ImageView drug_details_iv;
    private TextView drug_details_approvalNumber;
    private TextView drug_details_component;
    private TextView drug_details_effect;
    private TextView drug_details_mindMatter;
    private TextView drug_details_packing;
    private TextView drug_details_shape;
    private TextView drug_details_sideeffects;
    private TextView drug_details_storage;
    private TextView drug_details_taboo;
    private TextView drug_details_usage;
    private int id;
    private String name;
    private TextView drug_name;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        p.drugDetails(id);
    }

    @Override
    protected DrugDetailsPresenter setPresenter() {
        return new DrugDetailsPresenter();
    }

    @Override
    protected void initView() {
        drug_details_iv = findViewById(R.id.drug_details_iv);
        drug_name = findViewById(R.id.drug_name);
        drug_details_approvalNumber = findViewById(R.id.drug_details_approvalNumber);
        drug_details_component = findViewById(R.id.drug_details_component);
        drug_details_effect = findViewById(R.id.drug_details_effect);
        drug_details_mindMatter = findViewById(R.id.drug_details_mindMatter);
        drug_details_packing = findViewById(R.id.drug_details_packing);
        drug_details_shape = findViewById(R.id.drug_details_shape);
        drug_details_sideeffects = findViewById(R.id.drug_details_sideeffects);
        drug_details_storage = findViewById(R.id.drug_details_storage);
        drug_details_taboo = findViewById(R.id.drug_details_taboo);
        drug_details_usage = findViewById(R.id.drug_details_usage);
    }

    @Override
    protected int initLayout() {
        return R.layout.drug_details_activity;
    }

    @Override
    public void iDrugDetailsSuccess(DrugDetailsBean drugDetailsBean) {
           drug_name.setText(name);
           drug_details_approvalNumber.setText(drugDetailsBean.getResult().getApprovalNumber());
           drug_details_component.setText(drugDetailsBean.getResult().getComponent());
           drug_details_effect.setText(drugDetailsBean.getResult().getEffect());
           drug_details_mindMatter.setText(drugDetailsBean.getResult().getMindMatter());
           drug_details_packing.setText(drugDetailsBean.getResult().getPacking());
           drug_details_shape.setText(drugDetailsBean.getResult().getShape());
           drug_details_sideeffects.setText(drugDetailsBean.getResult().getSideEffects());
           drug_details_storage.setText(drugDetailsBean.getResult().getStorage());
           drug_details_taboo.setText(drugDetailsBean.getResult().getTaboo());
           drug_details_usage.setText(drugDetailsBean.getResult().getUsage());
    }
}
