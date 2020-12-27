package com.example.mini_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mini_apps.R;
import com.example.mini_apps.bean.JavaBean;

import java.util.ArrayList;
import java.util.List;

public class LinearsLayoutAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<JavaBean.DataDTO.CategoryListDTO> list;
    private ArrayList<JavaBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsListDTOS;
    private GridLayoutManager gridLayoutManager;

    public LinearsLayoutAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<JavaBean.DataDTO.CategoryListDTO> list) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_item_child, parent, false);
        return new LinearsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LinearsViewHolder linearsViewHolder = (LinearsViewHolder) holder;
        JavaBean.DataDTO.CategoryListDTO categoryListDTO = list.get(position);
        linearsViewHolder.tvHome.setText(categoryListDTO.getName());

        goodsListDTOS = new ArrayList<>();
        List<JavaBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = categoryListDTO.getGoodsList();
        goodsListDTOS.addAll(goodsList);
        gridLayoutManager = new GridLayoutManager(context, 2);
        linearsViewHolder.recyclerView.setLayoutManager(gridLayoutManager);
        GridLayoutAdapter gridLayoutAdapter = new GridLayoutAdapter(context, goodsListDTOS);
        linearsViewHolder.recyclerView.setAdapter(gridLayoutAdapter);

    }

    @Override
    public int getItemCount() {
        if (list.size() > 0) {
            return list.size();
        } else {
            return 0;
        }
    }

    private class LinearsViewHolder extends RecyclerView.ViewHolder {
        TextView tvHome;
        RecyclerView recyclerView;

        public LinearsViewHolder(View inflate) {
            super(inflate);
            tvHome = inflate.findViewById(R.id.tv_home);
            recyclerView = inflate.findViewById(R.id.recycler);
        }
    }
}
