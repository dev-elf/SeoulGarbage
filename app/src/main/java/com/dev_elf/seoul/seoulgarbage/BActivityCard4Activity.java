package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;
import com.dev_elf.seoul.seoulgarbage.adapters.WeatherAdapter;
import com.dev_elf.seoul.seoulgarbage.models.Weather;

import java.util.ArrayList;

/**
 * 날씨 보기 화면입니다
 */
public class BActivityCard4Activity extends SActivity {

    private WeatherAdapter weatherLayout;
    private ArrayList<Weather> weatherWeek = new ArrayList<>();
    private ImageView nowWeather; //현재날씨
    private TextView nowTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.b_activity_card4);
//        setContentView(R.layout.b_activity_card4);
        initLayout("날씨");
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */
        nowWeather = (ImageView) findViewById(R.id.nowWeather);
        nowTemperature = (TextView) findViewById(R.id.nowTemperature);
        nowWeather.setImageResource(R.drawable.b_weather_snow_thunder);
        for(int i=0;i<7;i++)weatherWeek.add(new Weather(i,i,i));
        weatherLayout = (WeatherAdapter) findViewById(R.id.dateLayer);
        weatherLayout.setWeather(weatherWeek);
    }


}
