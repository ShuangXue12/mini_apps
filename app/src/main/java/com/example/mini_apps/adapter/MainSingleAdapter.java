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

public class MainSingleAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public MainSingleAdapter(Context context, SingleLayoutHelper singleLayoutHelper) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.sl_item, parent, false);
        return new SingViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingViewHolder singViewHolder = (SingViewHolder) holder;
        singViewHolder.textView.setText("品牌制造商直供");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class SingViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public SingViewHolder(View inflate) {
            super(inflate);
            textView = inflate.findViewById(R.id.tv_title);
        }
    }
}
