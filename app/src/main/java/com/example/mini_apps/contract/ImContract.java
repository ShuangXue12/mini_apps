package com.example.mini_apps.contract;

import com.example.mini_apps.bean.JavaBean;
import com.example.mylibrary.Utils.Net.CallBack;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.base.BaseView;

public  class ImContract {

    public interface Mode extends BaseModel {
         <I> void next(String url, CallBack<I> callBack);
    }

    public interface Presenter {
        void Presen();
    }

    public interface View extends BaseView {
        void onSuucess(JavaBean i);
        void onErro(String err);
    }
}
