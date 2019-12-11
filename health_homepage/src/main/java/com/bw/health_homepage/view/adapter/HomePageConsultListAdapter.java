package com.bw.health_homepage.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bw.health_homepage.R;
import com.wd.mvp.model.bean.ConsultListBean;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageConsultListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ConsultListBean.ResultBean> consultListResult;

    public HomePageConsultListAdapter(Context context, List<ConsultListBean.ResultBean> consultListResult) {
        this.context = context;
        this.consultListResult = consultListResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_homepageconsultlist1, parent,false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            return viewHolder;
        }else if(viewType == 1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_homepageconsultlist2, parent, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(inflate);
            return viewHolder1;
        }else if(viewType == 2){
            View inflate =LayoutInflater.from(context).inflate(R.layout.item_homepageconsultlist3,parent,false);
            ViewHolder2 viewHolder2 = new ViewHolder2(inflate);
            return viewHolder2;
        }
         return null;
    }

    @Override
    public int getItemViewType(int position) {
        ConsultListBean.ResultBean resultBean = consultListResult.get(position);
        String[] split = resultBean.getThumbnail().split(";");
        int length = split.length;
        if (length == 0){
            return 0;
        }else if (length == 3){
            return 1;
        }else {
            return 2;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(consultListResult.get(position).getReleaseTime());
        if (itemViewType == 0){
            ViewHolder viewHolder =(ViewHolder) holder;
            viewHolder.consultlist1_tv1.setText(consultListResult.get(position).getTitle());
            viewHolder.consultlist1_tv2.setText(consultListResult.get(position).getSource()+"");
            viewHolder.consultlist1_tv3.setText(format);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = consultListResult.get(position).getId();
                }
            });
        }else if (itemViewType == 1){
            ViewHolder1 viewHolder1 = (ViewHolder1)holder;
            viewHolder1.consultlist2_tv1.setText(consultListResult.get(position).getTitle());
            viewHolder1.consultlist2_tv2.setText(consultListResult.get(position).getSource()+"");
            viewHolder1.consultlist2_tv3.setText(format);
            Glide.with(context).load(consultListResult.get(position).getThumbnail()).into(viewHolder1.consultlist2_iv1);
            Glide.with(context).load(consultListResult.get(position).getThumbnail()).into(viewHolder1.consultlist2_iv2);
            Glide.with(context).load(consultListResult.get(position).getThumbnail()).into(viewHolder1.consultlist2_iv3);
        }else if (itemViewType == 2){
            ViewHolder2 viewHolder2 = (ViewHolder2)holder;
            viewHolder2.consultlist3_tv1.setText(consultListResult.get(position).getTitle());
            viewHolder2.consultlist3_tv2.setText(consultListResult.get(position).getSource()+"");
            viewHolder2.consultlist3_tv3.setText(format);
            Glide.with(context).load(consultListResult.get(position).getThumbnail()).into(viewHolder2.consultlist3_iv1);
        }

//        String[] split = consultListResult.get(position).getThumbnail().split(";");
//        for (int j = 0; j <split.length ; j++) {
//            Glide.with(context).load(split[j]).into(viewHolder.advisorylist_img);
//        }
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
        return consultListResult.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView consultlist1_tv1;
        private final TextView consultlist1_tv2;
        private final TextView consultlist1_tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            consultlist1_tv1 = itemView.findViewById(R.id.consultlist1_tv1);
            consultlist1_tv2 = itemView.findViewById(R.id.consultlist1_tv2);
            consultlist1_tv3 = itemView.findViewById(R.id.consultlist1_tv3);

        }
    }
    private class ViewHolder1 extends RecyclerView.ViewHolder{

        private final TextView consultlist2_tv1;
        private final TextView consultlist2_tv2;
        private final TextView consultlist2_tv3;
        private final ImageView consultlist2_iv1;
        private final ImageView consultlist2_iv2;
        private final ImageView consultlist2_iv3;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            consultlist2_iv1 = itemView.findViewById(R.id.consultlist2_iv1);
            consultlist2_iv2 = itemView.findViewById(R.id.consultlist2_iv2);
            consultlist2_iv3 = itemView.findViewById(R.id.consultlist2_iv3);
            consultlist2_tv1 = itemView.findViewById(R.id.consultlist2_tv1);
            consultlist2_tv2 = itemView.findViewById(R.id.consultlist2_tv2);
            consultlist2_tv3 = itemView.findViewById(R.id.consultlist2_tv3);
        }
    }
    private class ViewHolder2 extends RecyclerView.ViewHolder{

        private final TextView consultlist3_tv1;
        private final TextView consultlist3_tv2;
        private final TextView consultlist3_tv3;
        private final ImageView consultlist3_iv1;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            consultlist3_iv1 = itemView.findViewById(R.id.consultlist3_iv1);
            consultlist3_tv1 = itemView.findViewById(R.id.consultlist3_tv1);
            consultlist3_tv2 = itemView.findViewById(R.id.consultlist3_tv2);
            consultlist3_tv3 = itemView.findViewById(R.id.consultlist3_tv3);
        }
    }
 }
