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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mini_apps.R;
import com.example.mini_apps.bean.JavaBean;

import java.util.List;

public class MainLinearAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private List<JavaBean.DataDTO.HotGoodsListDTO> list;
    private LinearLayoutHelper linearLayoutHelper;

    public MainLinearAdapter(Context context, List<JavaBean.DataDTO.HotGoodsListDTO> list, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.list = list;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gr3_item, parent, false);
        return new ImViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImViewHolder imViewHolder = (ImViewHolder) holder;
        JavaBean.DataDTO.HotGoodsListDTO hotGoodsListDTO = list.get(position);
        imViewHolder.textView.setText(hotGoodsListDTO.getName());
        imViewHolder.textView1.setText(hotGoodsListDTO.getGoods_brief());
        imViewHolder.textView2.setText("￥" + hotGoodsListDTO.getRetail_price());
        Glide.with(context).load(hotGoodsListDTO.getList_pic_url()).into(imViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ImViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView textView2;

        public ImViewHolder(View inflate) {
            super(inflate);
            imageView = inflate.findViewById(R.id.image_view3);
            textView = inflate.findViewById(R.id.tv_name_text4);
            textView1 = inflate.findViewById(R.id.tv_desc2);
            textView2 = inflate.findViewById(R.id.tv_pic);
        }
    }
}
