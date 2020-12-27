package com.example.mylibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<p extends BasePresenter> extends Fragment implements BaseView {
    public p presenter;
    private Context context =getActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), container, false);
        if(presenter==null){
            presenter=add();
            presenter.attch(this);
        }
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    protected abstract p add();

    protected abstract int getLayoutID();
}
