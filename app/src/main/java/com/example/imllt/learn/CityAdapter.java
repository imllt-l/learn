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

//public class CityAdapter extends ArrayAdapter<NanChang> {
//    private int resID;
//     public CityAdapter( Context context, int textViewResId,List<NanChang> objects){
//        super(context,textViewResId,objects);
//        resID = textViewResId;
//    }
//    @Override
//        public View getView(int position, View convertView, ViewGroup parent){
//            NanChang city_position = getItem(position);
//            View view;
//            ViewHolder viewHolder;
//            if(convertView ==null){
//                view =LayoutInflater.from(getContext()).inflate(resID,parent,false);
//                viewHolder = new ViewHolder();
//                viewHolder.positionImage = (ImageView) view.findViewById(R.id.position_Image);
//                viewHolder.positionName = (TextView) view.findViewById(R.id.position_name);
//                view.setTag(viewHolder);
//            }
//            else {
//               view = convertView;
//               viewHolder = (ViewHolder) view.getTag();
//            }
//        viewHolder.positionImage.setImageResource(city_position.getId());
//        viewHolder.positionName.setText(city_position.getName());
//        return  view;
//    }
//    class ViewHolder{
//        ImageView positionImage;
//        TextView positionName;
//    }
//}
public  class CityAdapter  extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    public Context mContext;
    private List<NanChang> mNanChang;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView positionImage;
        TextView positionName;

        ViewHolder(View view) {
            super(view);
            positionImage = (ImageView) view.findViewById(R.id.position_Image);
            positionName = (TextView) view.findViewById(R.id.position_name);
        }
    }

      CityAdapter(List<NanChang> nc_list) {
        mNanChang = nc_list;
    }

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
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

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
