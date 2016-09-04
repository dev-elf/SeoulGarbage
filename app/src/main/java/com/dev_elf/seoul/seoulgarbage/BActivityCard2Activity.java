package com.dev_elf.seoul.seoulgarbage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import net.daum.mf.map.api.MapView;


public class BActivityCard2Activity extends AppCompatActivity {

    private String API_KEY = "015f8275d8460de3f74152fb061e2512";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity_card2);

        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey(API_KEY);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
    }
}
