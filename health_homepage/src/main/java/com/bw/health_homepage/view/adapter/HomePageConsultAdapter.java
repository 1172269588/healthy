package com.bw.health_homepage.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.health_homepage.R;
import com.wd.mvp.model.bean.ConsultBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageConsultAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<ConsultBean.ResultBean> consultResult;
    private int a;
    public HomePageConsultAdapter(Context context, List<ConsultBean.ResultBean> consultResult) {
      this.consultResult = consultResult;
      this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_homepageconsult,null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
          ViewHolder viewHolder = (ViewHolder) holder;
          viewHolder.item_consult_tv.setText(consultResult.get(position).getName());

        if (a==position){
            viewHolder.item_consult_tv.setTextColor(Color.BLUE);
        }else {
            viewHolder.item_consult_tv.setTextColor(Color.GRAY);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=position;
                notifyDataSetChanged();
                mOnItemClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return consultResult.size();
    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_consult_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_consult_tv = itemView.findViewById(R.id.item_consult_tv);
        }
    }
}
