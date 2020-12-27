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

public class MainSingleAdapter4 extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public MainSingleAdapter4(Context context, SingleLayoutHelper singleLayoutHelper) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.s2_item, parent, false);
        return new ZyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ZyViewHolder zyViewHolder = (ZyViewHolder) holder;
//        zyViewHolder.tvName.setText("专题精选");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ZyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public ZyViewHolder(View inflate) {
            super(inflate);
            tvName = inflate.findViewById(R.id.tv_name);
        }
    }
}
