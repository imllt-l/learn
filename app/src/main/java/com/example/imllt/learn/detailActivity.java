package com.example.imllt.learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.TextureMapView;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

public class detailActivity extends AppCompatActivity {

    public static final String POSITION_NAME ="position_name";
    public static final String POSITION_IMAGE_ID ="position_image_id";
    public static final String POSITION_TEXT ="position_text";
    private TextureMapView mMapView;
    public LocationClient mLocationClient;
    private boolean isFirstLocate = true;
    private MapView mapView;
    private ImageView positionmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient = new LocationClient(getApplicationContext());
        setContentView(R.layout.activity_detail);
        //初始化
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.colltollBar);
        ImageView imageView = (ImageView)findViewById(R.id.toolBar_Iamageview);

        TextView textView =(TextView)findViewById(R.id.map_Imageview);

        positionmap = (ImageView) findViewById(R.id.position_map);
        /////
        Mapbox.getInstance(this, getString(R.string.access_token));
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String positionname = intent.getStringExtra(POSITION_NAME);
        int positionimageid = intent.getIntExtra(POSITION_IMAGE_ID,0);
        String position_card_text = intent.getStringExtra(POSITION_TEXT);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowHomeEnabled(true);
        }
        collapsingToolbarLayout.setTitle(positionname);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.cardview_light_background));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
        //Glide.with(this).load(positionimageid).into(imageView);
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
