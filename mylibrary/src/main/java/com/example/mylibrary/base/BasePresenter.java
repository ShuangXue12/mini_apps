package com.example.mylibrary.base;

public abstract class BasePresenter <V extends BaseView ,M extends BaseModel>{
    public V iview;
    public M imodel;

    public void attch(V v) {
        iview = v;
        imodel=setImodel();
    }

    public void destroy(){
        iview=null;
        imodel=null;
    }

    public abstract M setImodel();
}
