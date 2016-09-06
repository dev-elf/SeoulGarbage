package com.dev_elf.seoul.seoulgarbage.acitivities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.MainNav;
import com.dev_elf.seoul.seoulgarbage.R;

/**
 * Created by dnay2 on 2016-09-04.
 * Use Custom toolbar for Activities, all of the activity's parent
 */
public abstract class SActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    public TextView toolbarText;
    protected ImageView backBtn;
    protected Typeface fontNanum;
    protected Context mContext;

    protected static final int move_r_c = R.anim.move_r_c;
    protected static final int move_c_l = R.anim.move_c_l;
    protected static final int move_l_c = R.anim.move_l_c;
    protected static final int move_c_r = R.anim.move_c_r;

    protected static final int[] menuImg ={
            R.drawable.a_item_3garbage,
            R.drawable.a_item_4_address,
            R.drawable.a_item_2garbagetip,
            R.drawable.a_item_1weather,
            R.drawable.a_item_5setting,
            R.drawable.a_item_5setting
    };
    protected static final String[] menuName={
            "D-day설정",
            "쓰레기 배출 정보",
            "쓰레기 버리는 팁",
            "날씨보기",
            "다섯번째",
            "설정"
    };


    private final int fade_in = R.anim.fade_in;
    private final int fade_out = R.anim.fade_out;

    public void onCreate(Bundle savedInstanceState, int layout/*, boolean isNav*/) {
        if(this instanceof MainNav) overridePendingTransition(fade_in, fade_out);
        super.onCreate(savedInstanceState);
        setContentView(layout);
        mContext = this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        fontNanum = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothicRegular.ttf");


    }

    public void setToolbarText(String text){
        ((TextView) findViewById(R.id.toolbarText)).setText(text);
    }

    protected void initLayout(String text){
        backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        toolbarText = (TextView) findViewById(R.id.toolbarText);
        toolbarText.setTypeface(fontNanum);
        toolbarText.setText(text);
    }




    @Override
    public void onBackPressed() {
        if(!(mContext instanceof MainNav)){
            finish();
            overridePendingTransition(move_l_c, move_c_r);
        }
        else super.onBackPressed();
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(move_r_c, move_c_l);
    }
}

