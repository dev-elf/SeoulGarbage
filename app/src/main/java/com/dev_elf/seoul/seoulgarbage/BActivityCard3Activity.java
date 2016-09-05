package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;

public class BActivityCard3Activity extends SActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity_card3);
        initLayout("쓰레기버리는 정보 꿀팁");
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */
    }
}
