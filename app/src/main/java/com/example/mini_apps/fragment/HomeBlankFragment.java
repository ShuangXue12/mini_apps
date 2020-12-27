package com.example.mini_apps.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mini_apps.R;
import com.example.mini_apps.adapter.BannerSindleAdapter;
import com.example.mini_apps.adapter.EdSingleAdapter;
import com.example.mini_apps.adapter.GridAdapter;
import com.example.mini_apps.adapter.LinearLayoutAdapter;
import com.example.mini_apps.adapter.LinearsLayoutAdapter;
import com.example.mini_apps.adapter.MainGridAdapter;
import com.example.mini_apps.adapter.MainGridAdapter2;
import com.example.mini_apps.adapter.MainLinearAdapter;
import com.example.mini_apps.adapter.MainSingleAdapter;
import com.example.mini_apps.adapter.MainSingleAdapter2;
import com.example.mini_apps.adapter.MainSingleAdapter3;
import com.example.mini_apps.adapter.MainSingleAdapter4;
import com.example.mini_apps.bean.JavaBean;
import com.example.mini_apps.contract.ImContract;
import com.example.mini_apps.presenter.ImPresenter;
import com.example.mylibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeBlankFragment extends BaseFragment<ImPresenter> implements ImContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "HomeBlankFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecycler;
    private BannerSindleAdapter bannerSindleAdapter;
    private ArrayList<JavaBean.DataDTO.BannerDTO> bannerDTOS;
    private GridAdapter gridAdapter;
    private ArrayList<JavaBean.DataDTO.ChannelDTO> channelDTOS;
    private ArrayList<JavaBean.DataDTO.BrandListDTO> brandListDTOS;
    private MainGridAdapter mainGridAdapter;
    private MainSingleAdapter mainSingleAdapter;
    private MainSingleAdapter2 mainSingleAdapter2;
    private ArrayList<JavaBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private MainGridAdapter2 mainGridAdapter2;
    private MainSingleAdapter3 mainSingleAdapter3;
    private ArrayList<JavaBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private MainLinearAdapter mainLinearAdapter;
    private EdSingleAdapter edSingleAdapter;
    private MainSingleAdapter4 mainSingleAdapter4;
    private LinearLayoutHelper linearLayoutHelper;
    private GridLayoutHelper gridLayoutHelper3;
    private ColumnLayoutHelper columnLayoutHelper;
    private ArrayList<JavaBean.DataDTO.TopicListDTO> topicListDTOS;
    private LinearLayoutAdapter linearLayoutAdapter;
    private LinearLayoutHelper linearLayoutHelper1;
    private ArrayList<JavaBean.DataDTO.CategoryListDTO> categoryListDTOS;
    private LinearsLayoutAdapter linearsLayoutAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    protected void initData() {
        presenter.Presen();
    }

    @Override
    protected void initView(View inflate) {
        mRecycler = inflate.findViewById(R.id.recycler);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(recycledViewPool);

        recycledViewPool.setMaxRecycledViews(0,10);
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        edSingleAdapter = new EdSingleAdapter(getActivity(),singleLayoutHelper);

        //轮播图
        bannerDTOS = new ArrayList<>();
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        bannerSindleAdapter = new BannerSindleAdapter(getActivity(),singleLayoutHelper1,bannerDTOS);

        channelDTOS = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setSpanCount(5);
        gridAdapter = new GridAdapter(getActivity(),gridLayoutHelper,channelDTOS);

        //品牌制造商直供
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        mainSingleAdapter = new MainSingleAdapter(getActivity(),singleLayoutHelper2);


        brandListDTOS = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
//        gridLayoutHelper1.setWeights(new float[]{50,50});
//        gridLayoutHelper1.setItemCount(2);
        gridLayoutHelper1.setSpanCount(2);
//        gridLayoutHelper1.setAutoExpand(true);
        mainGridAdapter = new MainGridAdapter(getActivity(),gridLayoutHelper1,brandListDTOS);

        //周一周四，新品首发
        SingleLayoutHelper singleLayoutHelper3 = new SingleLayoutHelper();
        mainSingleAdapter2 = new MainSingleAdapter2(getActivity(),singleLayoutHelper3);

        newGoodsListDTOS = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        gridLayoutHelper2.setSpanCount(2);
        mainGridAdapter2 = new MainGridAdapter2(getActivity(),newGoodsListDTOS,gridLayoutHelper2);

        //人气推荐
        SingleLayoutHelper singleLayoutHelper4 = new SingleLayoutHelper();
        mainSingleAdapter3 = new MainSingleAdapter3(getActivity(),singleLayoutHelper4);

        hotGoodsListDTOS = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        mainLinearAdapter = new MainLinearAdapter(getActivity(),hotGoodsListDTOS,linearLayoutHelper);

        //专题精选
        SingleLayoutHelper singleLayoutHelper5 = new SingleLayoutHelper();
        mainSingleAdapter4 = new MainSingleAdapter4(getActivity(),singleLayoutHelper5);

        linearLayoutHelper = new LinearLayoutHelper();
        gridLayoutHelper3 = new GridLayoutHelper(3);
        columnLayoutHelper = new ColumnLayoutHelper();
        topicListDTOS = new ArrayList<>();
        linearLayoutAdapter = new LinearLayoutAdapter(getActivity(),linearLayoutHelper,topicListDTOS);

        linearLayoutHelper1 = new LinearLayoutHelper();
        categoryListDTOS = new ArrayList<>();
        linearsLayoutAdapter = new LinearsLayoutAdapter(getActivity(),linearLayoutHelper1,categoryListDTOS);


        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(edSingleAdapter);
        delegateAdapter.addAdapter(bannerSindleAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(mainSingleAdapter);
        delegateAdapter.addAdapter(mainGridAdapter);
        delegateAdapter.addAdapter(mainSingleAdapter2);
        delegateAdapter.addAdapter(mainGridAdapter2);
        delegateAdapter.addAdapter(mainSingleAdapter3);
        delegateAdapter.addAdapter(mainLinearAdapter);
        delegateAdapter.addAdapter(mainSingleAdapter4);
        delegateAdapter.addAdapter(linearLayoutAdapter);
        delegateAdapter.addAdapter(linearsLayoutAdapter);

        mRecycler.setLayoutManager(virtualLayoutManager);
        mRecycler.setAdapter(delegateAdapter);
    }

    @Override
    protected ImPresenter add() {
        return new ImPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home_blank;
    }

    @Override
    public void onSuucess(JavaBean i) {
        //banner
        List<JavaBean.DataDTO.BannerDTO> banner = i.getData().getBanner();
        bannerDTOS.addAll(banner);
        bannerSindleAdapter.notifyDataSetChanged();

        //5个小图标
        List<JavaBean.DataDTO.ChannelDTO> channel = i.getData().getChannel();
        channelDTOS.addAll(channel);
        gridAdapter.notifyDataSetChanged();

        //品牌制造商直供
        List<JavaBean.DataDTO.BrandListDTO> brandList = i.getData().getBrandList();
        brandListDTOS.addAll(brandList);
        mainGridAdapter2.notifyDataSetChanged();

        //周一周四，新品首发
        List<JavaBean.DataDTO.NewGoodsListDTO> newGoodsList = i.getData().getNewGoodsList();
        newGoodsListDTOS.addAll(newGoodsList);
        mainGridAdapter2.notifyDataSetChanged();

        //人气推荐
        List<JavaBean.DataDTO.HotGoodsListDTO> hotGoodsList = i.getData().getHotGoodsList();
        hotGoodsListDTOS.addAll(hotGoodsList);
        mainLinearAdapter.notifyDataSetChanged();

        //专业精选
        List<JavaBean.DataDTO.TopicListDTO> topicList = i.getData().getTopicList();
        topicListDTOS.addAll(topicList);
        linearLayoutAdapter.notifyDataSetChanged();

        List<JavaBean.DataDTO.CategoryListDTO> categoryList = i.getData().getCategoryList();
        categoryListDTOS.addAll(categoryList);
        linearsLayoutAdapter.notifyDataSetChanged();

    }

    @Override
    public void onErro(String err) {
        Log.d(TAG, "onErro: "+err);
    }
}