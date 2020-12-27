package com.example.mini_apps.adapter;

import android.content.Context;
import android.text.Html;
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

import java.util.List;

public class MainGridAdapter2 extends DelegateAdapter.Adapter {
    private Context context;
    private List<JavaBean.DataDTO.NewGoodsListDTO> list;
    private GridLayoutHelper gridLayoutHelper;

    public MainGridAdapter2(Context context, List<JavaBean.DataDTO.NewGoodsListDTO> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gr2_item, parent, false);
        return new YiViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JavaBean.DataDTO.NewGoodsListDTO newGoodsListDTO = list.get(position);
        YiViewHolder yiViewHolder = (YiViewHolder) holder;
        yiViewHolder.textView.setText(newGoodsListDTO.getName());
        yiViewHolder.textView1.setText("￥" + Html.fromHtml("" + newGoodsListDTO.getList_pic_url() + ""));
        Glide.with(context).load(newGoodsListDTO.getList_pic_url()).into(yiViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class YiViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;

        public YiViewHolder(View inflate) {
            super(inflate);
            imageView = inflate.findViewById(R.id.image_view2);
            textView = imageView.findViewById(R.id.tv_name_text2);
            textView1 = imageView.findViewById(R.id.tv_name_text3);
        }
    }
}
