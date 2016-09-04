package com.dev_elf.seoul.seoulgarbage.acitivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dev_elf.seoul.seoulgarbage.R;

/**
 * Created by dnay2 on 2016-09-04.
 * Use Custom toolbar for Activities, all of the activity's parent
 */
public abstract class SActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Custom toolbar");
        setSupportActionBar(toolbar);

    }


    void setToolbarText(String text){
        toolbar.setTitle(text);
    }



}
