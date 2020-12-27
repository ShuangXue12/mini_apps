package com.example.mini_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.mini_apps.R;
import com.example.mini_apps.bean.JavaBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerSindleAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<JavaBean.DataDTO.BannerDTO> list;

    public BannerSindleAdapter(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<JavaBean.DataDTO.BannerDTO> list) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        return new BannerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
        bannerViewHolder.banner.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        JavaBean.DataDTO.BannerDTO bannerDTO = (JavaBean.DataDTO.BannerDTO) path;
                        Glide.with(context).load(bannerDTO.getImage_url()).into(imageView);
                    }
                }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public BannerViewHolder(View inflate) {
            super(inflate);
            banner = inflate.findViewById(R.id.banner);
        }
    }
}
