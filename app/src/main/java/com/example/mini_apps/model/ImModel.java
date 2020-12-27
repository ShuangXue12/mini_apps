package com.example.mini_apps.model;

import com.example.mini_apps.contract.ImContract;
import com.example.mini_apps.presenter.ImPresenter;
import com.example.mylibrary.Utils.Net.CallBack;
import com.example.mylibrary.Utils.Net.RetrofitUtils;

public class ImModel implements ImContract.Mode {
    ImPresenter imPresenter;

    public ImModel(ImPresenter imPresenter) {
        this.imPresenter = imPresenter;
    }

    @Override
    public <I> void next(String url, CallBack<I> callBack) {
        RetrofitUtils.getRetrofitUils().get(url,callBack);
    }
}
