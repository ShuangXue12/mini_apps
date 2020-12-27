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

public class GridAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper singleLayoutHelper;
    private ArrayList<JavaBean.DataDTO.ChannelDTO> list;

    public GridAdapter(Context context, GridLayoutHelper singleLayoutHelper, ArrayList<JavaBean.DataDTO.ChannelDTO> list) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new GridViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JavaBean.DataDTO.ChannelDTO channelDTO = list.get(position);
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        Glide.with(context).load(channelDTO.getIcon_url()).into(gridViewHolder.image);
        gridViewHolder.tvname.setText(channelDTO.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {
        TextView tvname;
        ImageView image;

        public GridViewHolder(View inflate) {
            super(inflate);
            tvname = inflate.findViewById(R.id.tv_name);
            image = inflate.findViewById(R.id.image);
        }
    }
}
