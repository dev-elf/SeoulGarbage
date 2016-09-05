package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;
import android.view.ViewGroup;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;

import net.daum.mf.map.api.MapView;

/**
 * 쓰레기 버리는 화면입니다.
 */

public class BActivityCard2Activity extends SActivity {

    private String API_KEY = "015f8275d8460de3f74152fb061e2512";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.b_activity_card2);
//        setContentView(R.layout.b_activity_card2);
        initLayout("쓰레기 버리는 곳");
        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey(API_KEY);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */
    }
}
