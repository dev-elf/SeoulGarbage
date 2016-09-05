package com.dev_elf.seoul.seoulgarbage.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.R;
import com.dev_elf.seoul.seoulgarbage.models.Weather;

import java.util.ArrayList;

/**
 * Created by dnay2 on 2016-09-04.
 */
public class WeatherAdapter extends LinearLayout {

    private Context context;


    public WeatherAdapter(Context context) {
        super(context, null);
        this.context = context;
    }

    public WeatherAdapter(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        this.context = context;
    }

    public WeatherAdapter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setWeather(ArrayList<Weather> items){
        setOrientation(HORIZONTAL);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        for(Weather item : items){
            View v = View.inflate(context, R.layout.b_activity_card4_item, null);
            v.setLayoutParams(llp);
            TextView day = (TextView) v.findViewById(R.id.dateDay);
            ImageView weather = (ImageView) v.findViewById(R.id.dateWeather);
            TextView ddd = (TextView) v.findViewById(R.id.dateDdd);

            day.setText(String.valueOf(item.getDay()));
            if(item.getDdd().equals("토")) day.setTextColor(Color.BLUE);
            if(item.getDdd().equals("일")) day.setTextColor(Color.RED);
            weather.setImageResource(item.getWeatherImg());
            ddd.setText(item.getDdd());
            addView(v);
       }
    }
}
