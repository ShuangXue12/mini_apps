package com.example.mylibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity <p extends BasePresenter> extends AppCompatActivity implements BaseView{
    public   p presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if(presenter==null){
            presenter=add();
            presenter.attch(this);

        }
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    protected abstract int getLayoutID();
    protected abstract void initData();
    protected abstract void initView();
    protected abstract p add();
}
