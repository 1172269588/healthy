package com.bw.health_knowledge.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bw.health_knowledge.R;
import com.wd.mvp.model.bean.DiseaseDetailsBean;
import com.wd.mvp.presenter.DiseaseDetailsPresenter;
import com.wd.mvp.view.activity.BaseActivity;
import com.wd.mvp.view.interfaces.IContractView;

public class Disease_Activity extends BaseActivity<DiseaseDetailsPresenter> implements IContractView.iDiseaseDetailsView {

    private TextView disease_name;
    private TextView disease_details_pathology;
    private TextView disease_details_symptom;
    private TextView disease_details_benefitTaboo;
    private TextView disease_details_westernmedicine;
    private TextView disease_details_chinesemedicine;
    private int id;
    private String name;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        p.diseaseDetails(id);
    }

    @Override
    protected DiseaseDetailsPresenter setPresenter() {
        return new DiseaseDetailsPresenter();
    }

    @Override
    protected void initView() {
        disease_name = findViewById(R.id.disease_name);
        disease_details_pathology = findViewById(R.id.disease_details_pathology);
        disease_details_symptom = findViewById(R.id.disease_details_symptom);
        disease_details_benefitTaboo = findViewById(R.id.disease_details_benefitTaboo);
        disease_details_westernmedicine = findViewById(R.id.disease_details_westernmedicine);
        disease_details_chinesemedicine = findViewById(R.id.disease_details_chinesemedicine);

    }

    @Override
    protected int initLayout() {
        return R.layout.disease_details_activity;
    }

    @Override
    public void iDisDetailsSuccess(DiseaseDetailsBean diseaseDetailsBean) {
        disease_name.setText(name);
       disease_details_pathology.setText(diseaseDetailsBean.getResult().getPathology());
       disease_details_symptom.setText(diseaseDetailsBean.getResult().getSymptom());
       disease_details_benefitTaboo.setText(diseaseDetailsBean.getResult().getBenefitTaboo());
       disease_details_westernmedicine.setText(diseaseDetailsBean.getResult().getWesternMedicineTreatment());
       disease_details_chinesemedicine.setText(diseaseDetailsBean.getResult().getChineseMedicineTreatment());

    }
}
