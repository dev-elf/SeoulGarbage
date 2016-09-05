package com.dev_elf.seoul.seoulgarbage.models;

import com.dev_elf.seoul.seoulgarbage.R;

/**
 * Created by dnay2 on 2016-09-04.
 */
public class Weather {

    private int day;
    private int weatherImg;
    private int ddd;

    public Weather(int day, int weatherImg, int ddd) {
        this.day = day;
        this.weatherImg = weatherImg;
        this.ddd = ddd;
    }

    public int getDay() {
        return day;
    }

    public int getWeatherImg() {
        switch (weatherImg){
            case 10:return R.drawable.b_weather_sunny; /*맑음*/
            case 11:return R.drawable.b_weather_cloudy_little; /*구름조금*/
            case 12:return R.drawable.b_weather_cloudy; /*구름많음*/
            case 13:return R.drawable.b_weather_cloudy_much; /*흐림*/
            case 14:return R.drawable.b_weather_rainy_little; /*조금비*/
            case 15:return R.drawable.b_weather_rainy_much; /*많이비*/
            case 16:return R.drawable.b_weather_sunny_hot; /*폭염주의보*/
            case 17:return R.drawable.b_weather_snow; /*눈*/
            case 18:return R.drawable.b_weather_snow_thunder; /*번개눈*/
            case 19:return R.drawable.b_weather_rainy_thunder; /*번개비*/
            case 20:return 0; /**/
            case 21:return 0; /**/
            case 22:return 0; /**/
        }
        return 0;
    }

    public String getDdd() {
        switch (ddd){
            case 0:return "월";
            case 1:return "화";
            case 2:return "수";
            case 3:return "목";
            case 4:return "금";
            case 5:return "토";
            case 6:return "일";
//            case 7:return "월";
        }
        return "";
    }
}
