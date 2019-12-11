package com.bw.health_knowledge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.health_knowledge.R;
import com.wd.mvp.model.bean.FindDiseaseBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class FindDiseaseAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<FindDiseaseBean.ResultBean> findDiseaseResult;
    public FindDiseaseAdapter(Context context, List<FindDiseaseBean.ResultBean> findDiseaseResult) {
              this.context = context;
              this.findDiseaseResult = findDiseaseResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_finddisease, parent,false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       ViewHolder viewHolder = (ViewHolder) holder;
       viewHolder.item_finddisease_tv.setText(findDiseaseResult.get(position).getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        return findDiseaseResult.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView item_finddisease_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_finddisease_tv = itemView.findViewById(R.id.item_finddisease_tv);
        }
    }
}
