package com.example.imllt.learn;

import android.os.Bundle;
import android.support.transition.TransitionSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    //初始化变量
    private List<NanChang> nc_list = new ArrayList<>();
    private TextView tvSearch;
    private  LinearLayout mSearchLayout;
    private ScrollView mScrollView;
    private boolean isExpand = false;
    private ImageView ivImg;
    private TransitionSet mSet;
    InputStream inputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mScrollView = (ScrollView)findViewById(R.id.scrollView);
        initPosition();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycle_View);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        CityAdapter adapter = new CityAdapter(nc_list);
        recyclerView.setAdapter(adapter);
    }

    //初始化NanChang类
    private  void initPosition() {
        for (int i = 0; i < 2; i++) {
            NanChang lfs_Img = new NanChang("老福山", R.drawable.city_1,getResources().getString(R.string.lfs));
            NanChang bygc_Img = new NanChang("八一广场", R.drawable.city_2,getResources().getString(R.string.bygc));
            NanChang bydd_Img = new NanChang("八一大道", R.drawable.city_3,getResources().getString(R.string.bydd));
            NanChang byq_Img = new NanChang("八一桥", R.drawable.city_4,getResources().getString(R.string.byq));
            NanChang sjt_Img = new NanChang("绳金塔", R.drawable.city_5,getResources().getString(R.string.sjt));
            NanChang hcz_Img = new NanChang("火车站", R.drawable.city_6,getResources().getString(R.string.hcz));
            nc_list.add(lfs_Img);
            nc_list.add(bygc_Img);
            nc_list.add(bydd_Img);
            nc_list.add(byq_Img);
            nc_list.add(sjt_Img);
            nc_list.add(hcz_Img);
        }
    }



}
