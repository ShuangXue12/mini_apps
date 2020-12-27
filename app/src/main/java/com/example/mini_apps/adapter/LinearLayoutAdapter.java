package com.example.mini_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mini_apps.R;
import com.example.mini_apps.bean.JavaBean;

import java.util.ArrayList;

public class LinearLayoutAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<JavaBean.DataDTO.TopicListDTO> list;
    private LinearAdapter linearAdapter;

    public LinearLayoutAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<JavaBean.DataDTO.TopicListDTO> list) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.linear_item, parent, false);
        return new LinearViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LinearViewHolder linearViewHolder = (LinearViewHolder) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        linearViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        linearAdapter = new LinearAdapter(context,list);
        linearViewHolder.recyclerView.setAdapter(linearAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class LinearViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public LinearViewHolder(View inflate) {
            super(inflate);
            recyclerView = inflate.findViewById(R.id.recycler);
        }
    }
}
