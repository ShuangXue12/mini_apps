package com.example.mini_apps;

import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentTransaction;

import com.example.mini_apps.fragment.ChildBlankFragment;
import com.example.mini_apps.fragment.HomeBlankFragment;
import com.example.mini_apps.presenter.ImPresenter;
import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BasePresenter;

public class MainActivity extends BaseActivity {

    private LinearLayout mBntLl;
    private RadioGroup mRg;
    private HomeBlankFragment homeBlankFragment;
    private ChildBlankFragment childBlankFragment;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        homeBlankFragment = new HomeBlankFragment();
//        childBlankFragment = new ChildBlankFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.bnt_ll, homeBlankFragment)
                .show(homeBlankFragment)
                .hide(childBlankFragment)
                .commit();
    }

    @Override
    protected void initView() {
        mBntLl = (LinearLayout) findViewById(R.id.bnt_ll);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.rb1:
                        fragmentTransaction.show(homeBlankFragment).hide(childBlankFragment).commit();
                        break;
                    case R.id.rb2:
//                        fragmentTransaction.show(childBlankFragment).hide(homeBlankFragment).commit();
                        break;
                    case R.id.rb3:
//                        fragmentTransaction.show(childBlankFragment).hide(homeBlankFragment).commit();
                        break;
                    case R.id.rb4:
//                        fragmentTransaction.show(childBlankFragment).hide(homeBlankFragment).commit();
                        break;
                    case R.id.rb5:
//                        fragmentTransaction.show(childBlankFragment).hide(homeBlankFragment).commit();
                        break;
                }
            }
        });

    }

    @Override
    protected BasePresenter add() {
        return new ImPresenter();
    }
}