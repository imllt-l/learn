package com.example.imllt.learn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
public  class CityAdapter  extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    //声明变量
    public Context mContext;
    private List<NanChang> mNanChang;

    //创建Viewolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明变量
        CardView cardView;
        ImageView positionImage;
        TextView positionName;

        ViewHolder(View view) {
            super(view);
            //获取图片和文本资源
            positionImage = (ImageView) view.findViewById(R.id.position_Image);
            positionName = (TextView) view.findViewById(R.id.position_name);
        }
    }

      CityAdapter(List<NanChang> nc_list) {
        mNanChang = nc_list;
    }

    //初始化ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_first, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NanChang nc = mNanChang.get(position);
                Intent intent =new Intent(mContext,detailActivity.class);
                intent.putExtra(detailActivity.POSITION_NAME,nc.getName());
                intent.putExtra(detailActivity.POSITION_IMAGE_ID,nc.getId());
                intent.putExtra(detailActivity.POSITION_TEXT,nc.getdText());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    //将图片和文本资源与ViewHolder绑定
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NanChang nc = mNanChang.get(position);
       // holder.positionImage.setImageResource(nc.getId());
        Glide.with(mContext).load(nc.getId()).into(holder.positionImage);
        holder.positionName.setText(nc.getName());
    }

    @Override
    public int getItemCount() {
        return mNanChang.size();
    }

}
