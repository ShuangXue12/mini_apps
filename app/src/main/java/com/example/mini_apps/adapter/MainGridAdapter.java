package com.example.mini_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mini_apps.R;
import com.example.mini_apps.bean.JavaBean;

import java.util.ArrayList;

public class MainGridAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<JavaBean.DataDTO.BrandListDTO> list;

    public MainGridAdapter(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<JavaBean.DataDTO.BrandListDTO> list) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gr_item, parent, false);
        return new GrViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JavaBean.DataDTO.BrandListDTO brandListDTO = list.get(position);
        GrViewHolder grViewHolder = (GrViewHolder) holder;
        Glide.with(context).load(brandListDTO.getPic_url()).into(grViewHolder.image);
        grViewHolder.tvName.setText(brandListDTO.getName());
        grViewHolder.tvDesc.setText(brandListDTO.getFloor_price()+"元起");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class GrViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvName;
        TextView tvDesc;
        public GrViewHolder(View inflate) {
            super(inflate);
            image=inflate.findViewById(R.id.image_view);
            tvName=inflate.findViewById(R.id.tv_name_text);
            tvDesc=inflate.findViewById(R.id.tv_desc);
        }
    }
}
