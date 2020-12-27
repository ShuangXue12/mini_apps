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

public class LinearAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<JavaBean.DataDTO.TopicListDTO> list;

    public LinearAdapter(Context context, ArrayList<JavaBean.DataDTO.TopicListDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
        return new HomeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeViewHolder homeViewHolder = (HomeViewHolder) holder;
        JavaBean.DataDTO.TopicListDTO topicListDTO = list.get(position);
        homeViewHolder.tvJj.setText(topicListDTO.getTitle());
        homeViewHolder.tvPrice.setText(topicListDTO.getSubtitle());
        homeViewHolder.tvSong.setText("￥" + topicListDTO.getPrice_info());
        Glide.with(context).load(topicListDTO.getScene_pic_url()).into(homeViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvJj;
        TextView tvPrice;
        TextView tvSong;

        public HomeViewHolder(View inflate) {
            super(inflate);
            image = inflate.findViewById(R.id.image);
            tvJj = inflate.findViewById(R.id.tv_jj);
            tvPrice = inflate.findViewById(R.id.tv_price);
            tvSong = inflate.findViewById(R.id.tv_song);
        }
    }
}
