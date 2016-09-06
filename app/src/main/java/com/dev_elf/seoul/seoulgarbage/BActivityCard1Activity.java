package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;

/**
 * 일반쓰레기 버리는 시간을 보는 곳입니다.
 */
public class BActivityCard1Activity extends SActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        overridePendingTransition(R.anim.move_r_c, R.anim.move_c_l);
        super.onCreate(savedInstanceState, R.layout.b_activity_card1);

        initLayout("알림");
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */
    }
}
