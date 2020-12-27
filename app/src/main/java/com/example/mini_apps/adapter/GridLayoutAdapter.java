package com.example.mini_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mini_apps.R;
import com.example.mini_apps.bean.JavaBean;

import java.util.ArrayList;

public class GridLayoutAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<JavaBean.DataDTO.CategoryListDTO.GoodsListDTO> list;

    public GridLayoutAdapter(Context context, ArrayList<JavaBean.DataDTO.CategoryListDTO.GoodsListDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home_eight, parent, false);
        return new GridLayoutViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridLayoutViewHolder gridLayoutViewHolder = (GridLayoutViewHolder) holder;
        JavaBean.DataDTO.CategoryListDTO.GoodsListDTO goodsListDTO = list.get(position);
        gridLayoutViewHolder.tvHomeEight.setText(goodsListDTO.getName());
        gridLayoutViewHolder.tvHomeGrid.setText("￥" + goodsListDTO.getRetail_price());
        Glide.with(context).load(goodsListDTO.getList_pic_url()).into(gridLayoutViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class GridLayoutViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvHomeEight;
        TextView tvHomeGrid;

        public GridLayoutViewHolder(View inflate) {
            super(inflate);
            img = inflate.findViewById(R.id.img);
            tvHomeEight = inflate.findViewById(R.id.tv_home_eight);
            tvHomeGrid = inflate.findViewById(R.id.tv_home_grid);
        }
    }
}
