package com.example.imllt.learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
    //声明变量
    public static final String POSITION_NAME ="position_name";
    public static final String POSITION_IMAGE_ID ="position_image_id";
    public static final String POSITION_TEXT ="position_text";

    //定义CollapsingToolbar的状态值
    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }
    CollapsingToolbarLayoutState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //初始化
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.colltollBar);
        ImageView imageView = (ImageView)findViewById(R.id.toolBar_Iamageview);
        TextView textView =(TextView)findViewById(R.id.map_Imageview);


        //对上方的AppBar进行监听
        AppBarLayout appBar = (AppBarLayout)findViewById(R.id.appBar);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                ButtonBarLayout barText = (ButtonBarLayout) findViewById(R.id.barText);
                TextView barTextView = (TextView)findViewById(R.id.barTextView);
                Intent intent = getIntent();
                String positionname = intent.getStringExtra(POSITION_NAME);

                //判断CollapsingToolbar的状态
                if(verticalOffset == 0){
                    if(state != CollapsingToolbarLayoutState.EXPANDED){
                        state = CollapsingToolbarLayoutState.EXPANDED;
                        //collapsingToolbarLayout.setTitle("EXPANDED");
                    }
                }
                else if(Math.abs(verticalOffset)>=appBarLayout.getTotalScrollRange()){
                    if(state != CollapsingToolbarLayoutState.COLLAPSED){
                        //collapsingToolbarLayout.setTitle("");
                        barText.setVisibility(View.VISIBLE);
                        barTextView.setText(positionname);
                        state = CollapsingToolbarLayoutState.COLLAPSED;
                    }
                }
                else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if(state == CollapsingToolbarLayoutState.COLLAPSED){
                            barText.setVisibility(View.GONE);
                        }
                        //collapsingToolbarLayout.setTitle("INTERNEDIATE");//设置title为INTERNEDIATE
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }
            }
        });

        //初始化变量
        Intent intent = getIntent();
        String positionname = intent.getStringExtra(POSITION_NAME);
        int positionimageid = intent.getIntExtra(POSITION_IMAGE_ID,0);
        String position_card_text = intent.getStringExtra(POSITION_TEXT);

        //设置SupportActionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowHomeEnabled(true);
        }
        //赋值collapsingToolbar
        collapsingToolbarLayout.setTitle(positionname);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.cardview_light_background));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
        imageView.setImageResource(positionimageid);
        textView.setText(position_card_text);
    }
    @Override
        public  boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case android.R.id.home:
                    finish();
                    return true;
            }
            return super.onOptionsItemSelected(item);
    }

}
