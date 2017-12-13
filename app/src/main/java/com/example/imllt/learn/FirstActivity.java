package com.example.imllt.learn;

import android.os.Bundle;
import android.support.transition.TransitionSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private List<NanChang> nc_list = new ArrayList<>();
    private TextView tvSearch;
    private  LinearLayout mSearchLayout;
    private ScrollView mScrollView;
    private boolean isExpand = false;
    @Bind(R.id.iv_img)
    private ImageView ivImg;
    private Toolbar toolbar;
    private TransitionSet mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);
        tvSearch = (TextView)findViewById(R.id.tv_search);
        mSearchLayout = (LinearLayout)findViewById(R.id.ll_search);
        mScrollView = (ScrollView)findViewById(R.id.scrollView);
        tvSearch = (ImageView)findViewById(R.id.tv_search);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        initPosition();
        SDKInitializer.initialize(this.getApplication());
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycle_View);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        CityAdapter adapter = new CityAdapter(nc_list);
        recyclerView.setAdapter(adapter);
//        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                NanChang nc = nc_list.get(position);
//                Toast.makeText(FirstActivity.this,nc.getName(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
    private  void initPosition(){
        for (int i = 0;i<2;i++){
            NanChang lfs_Img = new NanChang("老福山",R.drawable.city_1);
            NanChang bygc_Img = new NanChang("八一广场",R.drawable.city_2);
            NanChang bydd_Img = new NanChang("八一大道",R.drawable.city_3);
            NanChang byq_Img = new NanChang("八一桥",R.drawable.city_4);
            NanChang sjt_Img = new NanChang("绳金塔",R.drawable.city_5);
            NanChang lfs2_Img = new NanChang("老福山",R.drawable.city_6);
            NanChang hcz_Img = new NanChang("火车站",R.drawable.city_7);
            nc_list.add(lfs_Img);
            nc_list.add(bygc_Img);
            nc_list.add(bydd_Img);
            nc_list.add(byq_Img);
            nc_list.add(sjt_Img);
            nc_list.add(lfs2_Img);
            nc_list.add(hcz_Img);
        }
    }
}
