package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;

public class BActivityCard5Activity extends SActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity_card5);
        initLayout("다섯번째화면");
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */
    }
}
