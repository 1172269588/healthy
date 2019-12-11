package com.bw.health_homepage.view.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.health_homepage.R;
import com.bw.health_homepage.view.adapter.DiseaseSearchVoListAdapter;
import com.bw.health_homepage.view.adapter.DoctorSearchVoListAdapter;
import com.bw.health_homepage.view.adapter.DrugsSearchVoListAdapter;
import com.bw.health_homepage.view.coustom.FlowView;
import com.wd.mvp.model.bean.HotSearchBean;
import com.wd.mvp.model.bean.SearchBean;
import com.wd.mvp.presenter.SearchPresenter;
import com.wd.mvp.view.activity.BaseActivity;
import com.wd.mvp.view.interfaces.IContractView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomePage_SearchActivity extends BaseActivity<SearchPresenter> implements IContractView.iSearchView {
    private RecordSQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private boolean hasData;
    private boolean whetherTheQuery = false;
    private ImageView ivHomeSearchBack;
    private EditText etHomeSearchTitle;
    private TextView ivHomeSearch;
    private FlowView flSearchHistory;
    private LinearLayout llRelevantSearchData;
    private ImageView ivNoSearchPic;
    private TextView tvNoSearchName;
    private RelativeLayout rlHomeNoSearch;
    private RecyclerView rvDoctor;
    private RecyclerView rvDrug;
    private RecyclerView rvSymptoms;
    private LinearLayout llSearchData;
    private TagFlowLayout tag_flow;

    @Override
    protected void initData() {
        p.getHomeHotSearch();
        //记录到sqlite中
        helper = new RecordSQLiteOpenHelper(this);
        String tempName = etHomeSearchTitle.getText().toString();
        queryData(tempName);
    }

    @Override
    protected SearchPresenter setPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initView() {
        ivHomeSearchBack = findViewById(R.id.iv_home_search_back);
        etHomeSearchTitle = findViewById(R.id.et_home_search_title);
        ivHomeSearch = findViewById(R.id.iv_home_search);
        flSearchHistory = findViewById(R.id.fl_searchHistory);
        llRelevantSearchData = findViewById(R.id.ll_relevantSearchData);
        ivNoSearchPic = findViewById(R.id.iv_noSearch_pic);
        tvNoSearchName = findViewById(R.id.tv_noSearch_name);
        rlHomeNoSearch = findViewById(R.id.rl_home_noSearch);
        rvDoctor =  findViewById(R.id.rv_doctor);
        rvDrug =  findViewById(R.id.rv_drug);
        rvSymptoms =  findViewById(R.id.rv_symptoms);
        llSearchData =  findViewById(R.id.ll_searchData);
        tag_flow = findViewById(R.id.tag_flow);

        ivHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etHomeSearchTitle.getText().toString();
                search(keyword);
            }
        });
        ivHomeSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void search(String keyword) {
        TextView textView = new TextView(this);
        textView.setText(keyword);
        flSearchHistory.addView(textView);
        try {
            String decode = URLDecoder.decode(keyword, "UTF-8");
            p.getHomePagerSearch(decode);
            AddHistory();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void AddHistory() {

        hasData = hasData(etHomeSearchTitle.getText().toString().trim());
        // 3. 若存在，则不保存；若不存在，则将该搜索字段保存（插入）到数据库，并作为历史搜索记录
        if (!hasData) {
            insertData(etHomeSearchTitle.getText().toString().trim()); // ->>关注4
            queryData("");
        }
    }

    private void queryData(String tempName) {
        if (!whetherTheQuery) {
            // 1. 模糊搜索
            Cursor cursor = helper.getReadableDatabase().rawQuery(
                    "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                // 2. 创建adapter适配器对象 & 装入模糊搜索的结果
                TextView tv = new TextView(this);
                tv.setPadding(0, 10, 0, 10);
                tv.setText(name);
                flSearchHistory.addView(tv);
                whetherTheQuery = true;
            }

        }
    }
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    private boolean hasData(String trim) {
       return false;
    }

    @Override
    protected int initLayout() {
        return R.layout.homepage_search_activity;
    }

    @Override
    public void iSearchSuccess(SearchBean searchBean) {
       SearchBean.ResultBean result = searchBean.getResult();
        //病症
        List<SearchBean.ResultBean.DiseaseSearchVoListBean> diseaseSearchVoList = result.getDiseaseSearchVoList();
        //医生
        List<SearchBean.ResultBean.DoctorSearchVoListBean> doctorSearchVoList = result.getDoctorSearchVoList();
        //药品
        List<SearchBean.ResultBean.DrugsSearchVoListBean> drugsSearchVoList = result.getDrugsSearchVoList();
        if (diseaseSearchVoList != null && diseaseSearchVoList.size() > 0 || doctorSearchVoList != null && doctorSearchVoList.size() > 0 || drugsSearchVoList != null && drugsSearchVoList.size() > 0) {
            rlHomeNoSearch.setVisibility(View.GONE);
            llSearchData.setVisibility(View.VISIBLE);
            llRelevantSearchData.setVisibility(View.GONE);

            //创建适配器
            DiseaseSearchVoListAdapter diseaseSearchVoListAdapter = new DiseaseSearchVoListAdapter(R.layout.layout_home_search_item, diseaseSearchVoList);
            //设置每个item的排列方式
            rvSymptoms.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
            //设置上适配器
            rvSymptoms.setAdapter(diseaseSearchVoListAdapter);

            //创建适配器
            DoctorSearchVoListAdapter doctorSearchVoListAdapter = new DoctorSearchVoListAdapter(R.layout.layout_home_search_item,doctorSearchVoList);
            //设置每个item的排列方式
            rvDoctor.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            //设置上适配器
            rvDoctor.setAdapter(doctorSearchVoListAdapter);

            //创建适配器
            DrugsSearchVoListAdapter drugsSearchVoListAdapter = new DrugsSearchVoListAdapter(R.layout.layout_home_search_item,drugsSearchVoList);
            //设置每个item的排列方式
            rvDrug.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            //设置上适配器
            rvDrug.setAdapter(drugsSearchVoListAdapter);
        } else {
            rlHomeNoSearch.setVisibility(View.VISIBLE);
            llSearchData.setVisibility(View.GONE);
            llRelevantSearchData.setVisibility(View.GONE);
            tvNoSearchName.setText(etHomeSearchTitle.getText().toString());
        }
    }

    @Override
    public void iHotSearchSuccess(HotSearchBean hotSearchBean) {
        List<HotSearchBean.ResultBean> hotSearchResult = hotSearchBean.getResult();
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < hotSearchResult.size(); i++) {
            String name = hotSearchResult.get(i).getName();
            datas.add(name);
        }
        tag_flow.setAdapter(new TagAdapter<String>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = new TextView(HomePage_SearchActivity.this);
                tv.setText(datas.get(position));
                tv.setPadding(10, 5, 10, 5);
                tv.setBackgroundResource(R.drawable.fl_top_search_background);
                return tv;
            }
        });
        tag_flow.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(HomePage_SearchActivity.this, hotSearchResult.get(position).getName() + "-" + hotSearchResult.get(position).getId(), Toast.LENGTH_SHORT).show();
                search(hotSearchResult.get(position).getName());
                return true;
            }
        });
    }

}
