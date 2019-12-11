package com.bw.health_knowledge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.health_knowledge.R;
import com.wd.mvp.model.bean.FindDrugBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.http.GET;

public class FindDrugAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<FindDrugBean.ResultBean> findDrugResult;
    public FindDrugAdapter(Context context, List<FindDrugBean.ResultBean> findDrugResult) {
          this.context = context;
          this.findDrugResult  = findDrugResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_finddrug, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
         ViewHolder viewHolder = (ViewHolder)holder;
         viewHolder.item_finddrug_tv.setText(findDrugResult.get(position).getName());
         Glide.with(context).load(findDrugResult.get(position).getPicture()).into(viewHolder.item_finddrug_iv);
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
        return findDrugResult.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView item_finddrug_iv;
        private final TextView item_finddrug_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_finddrug_iv = itemView.findViewById(R.id.item_finddrug_iv);
            item_finddrug_tv = itemView.findViewById(R.id.item_finddrug_tv);
        }
    }
}
