package com.bw.health_homepage.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.health_homepage.R;
import com.wd.mvp.model.bean.OfficeBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageOfficeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<OfficeBean.ResultBean> result;
    public HomePageOfficeAdapter(Context context, List<OfficeBean.ResultBean> result) {
           this.context = context;
           this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_homepageoffice, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.item_office_tv.setText(result.get(position).getDepartmentName());

        Glide.with(context).load(result.get(position).getPic())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
        .        into(viewHolder.item_office_iv);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView item_office_iv;
        private final TextView item_office_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_office_iv = itemView.findViewById(R.id.item_office_iv);
            item_office_tv = itemView.findViewById(R.id.item_office_tv);

        }
    }
}
