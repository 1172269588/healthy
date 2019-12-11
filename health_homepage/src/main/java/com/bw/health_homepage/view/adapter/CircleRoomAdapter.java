package com.bw.health_homepage.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.health_homepage.R;
import com.wd.mvp.model.bean.OfficeBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CircleRoomAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<OfficeBean.ResultBean> result;
    public CircleRoomAdapter(Context context, List<OfficeBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_circleroom, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         ViewHolder viewHolder = (ViewHolder) holder;
         viewHolder.circleroom_tv.setText(result.get(position).getDepartmentName());
         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView circleroom_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleroom_tv = itemView.findViewById(R.id.circleroom_tv);
        }
    }
}
