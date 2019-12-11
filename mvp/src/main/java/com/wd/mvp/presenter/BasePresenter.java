package com.wd.mvp.presenter;

/**
 * date:2019/12/3
 * author:郑宏宇(Msi)
 * function:
 */
public class BasePresenter <V>{

    private V v;

    public V getV() {
        return v;
    }

    public void attach(V v){
        this.v = v;
    }

    public void detach(){
        this.v = null;
    }
}
