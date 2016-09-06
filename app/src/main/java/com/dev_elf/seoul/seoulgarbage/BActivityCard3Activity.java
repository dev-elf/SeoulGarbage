package com.dev_elf.seoul.seoulgarbage;

import android.os.Bundle;
import android.widget.ListView;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;
import com.dev_elf.seoul.seoulgarbage.adapters.GarbageTipAdapter;
import com.dev_elf.seoul.seoulgarbage.models.GarbageTip;

import java.util.ArrayList;

/**
 * 쓰레기 버리는 법 리스트뷰
 */
public class BActivityCard3Activity extends SActivity {

    ListView mListView; //버리는법 분류 expandable ListView 로 구현하는 것이 옳다 아이템을 누르면 확장되도록
    ArrayList<GarbageTip> tipItem = new ArrayList<>(); // 내용물 제목과 내용 두개(String, String)가 필드임



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.b_activity_card3);
//        setContentView(R.layout.b_activity_card3);
        initLayout("쓰레기버리는 정보 꿀팁");
    }

    @Override
    protected void initLayout(String text) {
        super.initLayout(text);
        /**
         * 화면구성은 여기에
         */
        for(int i=1; i<=10;i++) tipItem.add(new GarbageTip("아이템"+i+" 입니다", "내용물입니다.\n이건 "+i+"번째 내용물입니다."));
        mListView = (ListView) findViewById(R.id.tipList);
        mListView.setAdapter(new GarbageTipAdapter(this, tipItem));
    }
}
