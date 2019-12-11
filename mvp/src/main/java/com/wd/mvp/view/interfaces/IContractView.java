package com.wd.mvp.view.interfaces;

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

public interface IContractView {
    //HomePage首页
    interface iHomePageView {
        //问诊咨询
        void iOfficeSuccess(OfficeBean officeBean);
        //Banner轮播
        void iBannerSuccess(BannerBean bannerBean);
        //咨询板块
        void iConsultSuccess(ConsultBean consultBean);
        //咨询列表
        void iConsultListSuccess(ConsultListBean consultListBean);

    }
    //常见病症
    interface iDiseaseView{
        //病症科室
        void iOffice(OfficeBean officeBean);
        //病症列表
        void iDiseaseSuccess(FindDiseaseBean findDiseaseBean);
    }
    //常见药品
    interface iDrugView{
        //药品分类
        void iDrug(DrugBean drugBean);
        //药品列表
        void iDrugSuccess(FindDrugBean findDrugBean);
    }
    //点击病症跳转病症详情
    interface iDiseaseDetailsView{
        void iDisDetailsSuccess(DiseaseDetailsBean diseaseDetailsBean);
    }
    //点击药品跳转药品详情
    interface iDrugDetailsView{
        void iDrugDetailsSuccess(DrugDetailsBean drugDetailsBean);
    }
    //病友圈列表
    interface iCircleView{
        void iRoomSuccess(OfficeBean officeBean);
        void iCircleSuccess(CircleBean circleBean);
    }

    //首页搜索
    interface iSearchView{
        void iSearchSuccess(SearchBean searchBean);
        //热门搜索
        void iHotSearchSuccess(HotSearchBean hotSearchBean);
    }
    //登录
    interface iLoginView{
        void iLoginSuccess(LoginBean loginBean);
    }
}
