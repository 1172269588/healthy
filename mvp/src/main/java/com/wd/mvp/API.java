package com.wd.mvp;

import com.wd.mvp.model.bean.BannerBean;
import com.wd.mvp.model.bean.CircleBean;
import com.wd.mvp.model.bean.ConsultBean;
import com.wd.mvp.model.bean.ConsultListBean;
import com.wd.mvp.model.bean.DiseaseDetailsBean;
import com.wd.mvp.model.bean.DrugBean;
import com.wd.mvp.model.bean.DrugDetailsBean;
import com.wd.mvp.model.bean.FindDiseaseBean;
import com.wd.mvp.model.bean.FindDrugBean;
import com.wd.mvp.model.bean.HotSearchBean;
import com.wd.mvp.model.bean.LoginBean;
import com.wd.mvp.model.bean.OfficeBean;
import com.wd.mvp.model.bean.SearchBean;
import com.wd.mvp.model.url.CantantUrl;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * date:2019/12/4
 * author:郑宏宇(Msi)
 * function:
 */
public interface API {
    //首页轮播
    @GET(CantantUrl.BANNER_URL)
    Observable<BannerBean>getBanner();
    //首页问诊咨询
    @GET(CantantUrl.OFFICE_URL)
    Observable<OfficeBean>getOffice();
    //健康咨询
    @GET(CantantUrl.CONSULT_URL)
    Observable<ConsultBean>getConsult();
    //健康咨询列表
    @GET(CantantUrl.CONSULTLIST_URL)
    Observable<ConsultListBean>getConsultList(@Query("plateId")int plateId,@Query("page")int page,@Query("count") int count);
    //根据科室查看对应病症
    @GET(CantantUrl.DISEASE_URL)
    Observable<FindDiseaseBean>getDisease(@Query("departmentId")int departmentId);
    //药品分类
    @GET(CantantUrl.IDRUG_URL)
    Observable<DrugBean>getiDrug();
    //根据药品类目查询常见药品
    @GET(CantantUrl.DRUG_URL)
    Observable<FindDrugBean>getDrug(@Query("drugsCategoryId")int drugsCategoryId,@Query("page")int page,@Query("count")int count);
    //点击病症跳转病症详情
    @GET(CantantUrl.DISEASE_DETAILS_URL)
    Observable<DiseaseDetailsBean>getDiseaseDetails(@Query("id")int id);
    //点击药品跳转药品详情
    @GET(CantantUrl.DRUG_DETAILS_URL)
    Observable<DrugDetailsBean>getDrugDetails(@Query("id")int id);
    //病友圈科室
    @GET(CantantUrl.OFFICE_URL)
    Observable<OfficeBean>getRoom();
    //病友圈列表
    @GET(CantantUrl.CIRCLE_URL)
    Observable<CircleBean>getCircle(@Query("departmentId")int departmentId,@Query("page")int page,@Query("count")int count);
    //首页搜索
    @GET(CantantUrl.SEARCH_URL)
    Observable<SearchBean>getSearch(@Query("keyWord")String keyWord);
    //热门搜索
    @GET(CantantUrl.HOTSEARCH_URL)
    Observable<HotSearchBean>getHotSearch();
    //登录
    @FormUrlEncoded
    @POST(CantantUrl.LOGIN_URL)
    Observable<LoginBean>getLogin(@Field("email")String email,@Field("pwd")String pwd);

}
