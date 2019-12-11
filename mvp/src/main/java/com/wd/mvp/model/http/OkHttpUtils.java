package com.wd.mvp.model.http;

import com.wd.mvp.API;
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

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:2019/12/3
 * author:郑宏宇(Msi)
 * function:
 */
public class OkHttpUtils<B> {
    private final OkHttpClient mOkHttpClient;
    private final Retrofit mRetrofit;
    private final API mIApi;
    private static OkHttpUtils mOkHttpUtils = null;

    private OkHttpUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(CantantUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mIApi = mRetrofit.create(API.class);
    }

    public static OkHttpUtils getInstance() {
        if (mOkHttpUtils == null) {
            return new OkHttpUtils();
        }
        return mOkHttpUtils;
    }

    public void getBanner(final IOkCallBack<BannerBean> bannerBeanIOkCallBack, Class<B> bannerBeanClass) {
        Observable<BannerBean> banner = mIApi.getBanner();
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        bannerBeanIOkCallBack.callSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getZixun(IOkCallBack<OfficeBean> officeBeanIOkCallBack, Class<B> officeBeanClass) {
        Observable<OfficeBean> office = mIApi.getOffice();
        office.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OfficeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OfficeBean officeBean) {
                        officeBeanIOkCallBack.callSuccess(officeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getConsult(IOkCallBack<ConsultBean> consultBeanIOkCallBack, Class<B> consultBeanClass) {
        Observable<ConsultBean> consult = mIApi.getConsult();
        consult.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConsultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConsultBean consultBean) {
                        consultBeanIOkCallBack.callSuccess(consultBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getConsultList(IOkCallBack<ConsultListBean> consultListBeanIOkCallBack, Class<B> consultListBeanClass, int plateId, int page, int count) {
        Observable<ConsultListBean> consultList = mIApi.getConsultList(plateId, page, count);
        consultList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConsultListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConsultListBean consultListBean) {
                        consultListBeanIOkCallBack.callSuccess(consultListBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getiOffice(IOkCallBack<OfficeBean> officeBeanIOkCallBack, Class<B> officeBeanClass) {
        Observable<OfficeBean> office = mIApi.getOffice();
        office.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OfficeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OfficeBean officeBean) {
                        officeBeanIOkCallBack.callSuccess(officeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDisease(IOkCallBack<FindDiseaseBean> findDiseaseBeanIOkCallBack, Class<B> findDiseaseBeanClass, int departmentId) {
        Observable<FindDiseaseBean> disease = mIApi.getDisease(departmentId);
        disease.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindDiseaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDiseaseBean findDiseaseBean) {
                        findDiseaseBeanIOkCallBack.callSuccess(findDiseaseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getiDrug(IOkCallBack<DrugBean> drugBeanIOkCallBack, Class<B> drugBeanClass) {
        Observable<DrugBean> drugBeanObservable = mIApi.getiDrug();
        drugBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DrugBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DrugBean drugBean) {
                        drugBeanIOkCallBack.callSuccess(drugBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDrug(IOkCallBack<FindDrugBean> findDrugBeanIOkCallBack, Class<B> findDrugBeanClass, int drugsCategoryId, int page, int count) {
        Observable<FindDrugBean> drug = mIApi.getDrug(drugsCategoryId, page, count);
        drug.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindDrugBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDrugBean findDrugBean) {
                        findDrugBeanIOkCallBack.callSuccess(findDrugBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDiseaseDetails(IOkCallBack<DiseaseDetailsBean> diseaseDetailsBeanIOkCallBack, Class<B> diseaseDetailsBeanClass, int id) {
        Observable<DiseaseDetailsBean> diseaseDetails = mIApi.getDiseaseDetails(id);
        diseaseDetails.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiseaseDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiseaseDetailsBean diseaseDetailsBean) {
                        diseaseDetailsBeanIOkCallBack.callSuccess(diseaseDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDrugDetails(IOkCallBack<DrugDetailsBean> drugDetailsBeanIOkCallBack, Class<B> drugDetailsBeanClass, int id) {
        Observable<DrugDetailsBean> drugDetails = mIApi.getDrugDetails(id);
        drugDetails.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DrugDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DrugDetailsBean drugDetailsBean) {
                        drugDetailsBeanIOkCallBack.callSuccess(drugDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getRoom(IOkCallBack<OfficeBean> officeBeanIOkCallBack, Class<B> officeBeanClass) {
        Observable<OfficeBean> room = mIApi.getRoom();
        room.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OfficeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OfficeBean officeBean) {
                        officeBeanIOkCallBack.callSuccess(officeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getCircle(IOkCallBack<CircleBean> circleBeanIOkCallBack, Class<B> circleBeanClass, int id, int page, int count) {
        Observable<CircleBean> circle = mIApi.getCircle(id, page, count);
        circle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CircleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CircleBean circleBean) {
                        circleBeanIOkCallBack.callSuccess(circleBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getHomePagerSearch(IOkCallBack<SearchBean> searchBeanIOkCallBack, Class<B> searchBeanClass, String keyWord) {
        Observable<SearchBean> search = mIApi.getSearch(keyWord);
        search.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        searchBeanIOkCallBack.callSuccess(searchBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getHomeHotSearch(IOkCallBack<HotSearchBean> hotSearchBeanIOkCallBack, Class<B> hotSearchBeanClass) {
        Observable<HotSearchBean> hotSearch = mIApi.getHotSearch();
        hotSearch.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotSearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotSearchBean hotSearchBean) {
                        hotSearchBeanIOkCallBack.callSuccess(hotSearchBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getLogin(IOkCallBack<LoginBean> loginBeanIOkCallBack, Class<B> loginBeanClass, String email, String s) {
        Observable<LoginBean> login = mIApi.getLogin(email, s);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        loginBeanIOkCallBack.callSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface IOkCallBack<B> {
        void callSuccess(B bean);

        void callError(String msg);
    }
}
