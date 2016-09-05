package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;
import com.dev_elf.seoul.seoulgarbage.adapters.WeatherAdapter;
import com.dev_elf.seoul.seoulgarbage.models.Weather;

import java.util.ArrayList;

public class BActivityCard4Activity extends SActivity {

    private WeatherAdapter weatherLayout;
    private ArrayList<Weather> weatherWeek = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity_card4);
        initLayout("날씨");
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */

        weatherLayout = (WeatherAdapter) findViewById(R.id.dateLayer);
    }


}
