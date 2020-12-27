package com.example.mini_apps.presenter;

import com.example.mini_apps.bean.JavaBean;
import com.example.mini_apps.contract.ImContract;
import com.example.mini_apps.model.ImModel;
import com.example.mylibrary.Utils.Net.CallBack;
import com.example.mylibrary.Utils.Net.ConUrl;
import com.example.mylibrary.base.BasePresenter;

public class ImPresenter extends BasePresenter<ImContract.View, ImContract.Mode> implements ImContract.Presenter {

    @Override
    public ImContract.Mode setImodel() {
        return new ImModel(this);
    }

    @Override
    public void Presen() {
        imodel.next(ConUrl.BannUrl, new CallBack<JavaBean>() {
            @Override
            public void OnSuucess(JavaBean javaBean) {
                iview.onSuucess(javaBean);
            }

            @Override
            public void OnErro(String err) {
                iview.onErro(err);
            }
        });
    }
}
