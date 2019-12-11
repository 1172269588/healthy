package com.wd.mvp.model.url;

public class CantantUrl {
    public static boolean isDeBug = true;
    public static String testUrl = "http://172.17.8.100/";
    public static String lineUrl = "http://mobile.bwstudent.com/";
    public static String baseUrl(){
        return isDeBug == true ? testUrl:lineUrl;
    }
    //公共的
    public static final String BASE_URL =  baseUrl();
    //Banner
    public static final String BANNER_URL="health/share/v1/bannersShow";
    //问诊咨询列表室
    public static final String OFFICE_URL="health/share/knowledgeBase/v1/findDepartment";
    //健康咨询
    public static final String CONSULT_URL="health/share/information/v1/findInformationPlateList";
    //健康咨询列表
    public static final String CONSULTLIST_URL="health/share/information/v1/findInformationList";
    //首页搜索
    public static final String HOMESEARCH_URL="health/share/v1/homePageSearch";
    //根据科室查看对应病症
    public static final String DISEASE_URL="health/share/knowledgeBase/v1/findDiseaseCategory";
    //根据药品类目查询常见药品
    public static final String DRUG_URL="health/share/knowledgeBase/v1/findDrugsKnowledgeList";
    //药品分类
    public static final String IDRUG_URL="health/share/knowledgeBase/v1/findDrugsCategoryList";
    //病症详情
    public static final String DISEASE_DETAILS_URL="health/share/knowledgeBase/v1/findDiseaseKnowledge";
    //药品详情
    public static final String DRUG_DETAILS_URL="health/share/knowledgeBase/v1/findDrugsKnowledge";
    //病友圈列表
    public static final String CIRCLE_URL="health/user/sickCircle/v1/findSickCircleList";
    //首页搜索
    public static final String SEARCH_URL="health/share/v1/homePageSearch";
    //热门搜索
    public static final String HOTSEARCH_URL="health/share/v1/popularSearch";
    //登录
    public static final String LOGIN_URL="health/user/v1/login";
}
