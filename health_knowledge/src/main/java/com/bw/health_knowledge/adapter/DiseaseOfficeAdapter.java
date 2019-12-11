package com.bw.health_knowledge.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.health_knowledge.R;
import com.wd.mvp.model.bean.OfficeBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DiseaseOfficeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<OfficeBean.ResultBean> officeResult;
    private int a;
    public DiseaseOfficeAdapter(Context context, List<OfficeBean.ResultBean> officeResult) {
          this.context = context;
          this.officeResult = officeResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_diseaseoffice, parent,false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.item_deseaseoffice_tv.setText(officeResult.get(position).getDepartmentName());
        if (a==position){
            viewHolder.item_deseaseoffice_tv.setBackgroundColor(Color.WHITE);
        }else {
            viewHolder.item_deseaseoffice_tv.setBackgroundColor(Color.LTGRAY);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = position;
                notifyDataSetChanged();
                mOnItemClickListener.onItemClick(position);
            }
        });
    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    @Override
    public int getItemCount() {
        return officeResult.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_deseaseoffice_tv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_deseaseoffice_tv = itemView.findViewById(R.id.item_diseaseoffice_tv);

        }
    }
}
