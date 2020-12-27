package com.example.mini_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mini_apps.R;

public class MainSingleAdapter3 extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public MainSingleAdapter3(Context context, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sl2_item, parent, false);
        return new ImViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ImViewHolder imViewHolder = (ImViewHolder) holder;
//        imViewHolder.textView.setText("人气推荐");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ImViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ImViewHolder(View inflate) {
            super(inflate);
            textView = inflate.findViewById(R.id.tv_title1);
        }
    }
}
