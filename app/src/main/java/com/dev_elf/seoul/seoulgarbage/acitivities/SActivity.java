package com.dev_elf.seoul.seoulgarbage.acitivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.R;

/**
 * Created by dnay2 on 2016-09-04.
 * Use Custom toolbar for Activities, all of the activity's parent
 */
public abstract class SActivity extends AppCompatActivity {


    protected Toolbar toolbar;
    protected TextView toolbarText;
    protected ImageView backBtn;

    public void onCreate(Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        toolbarText = (TextView) findViewById(R.id.toolbarText);

    }

    protected void setToolbarText(String text){
        toolbarText.setText(text);
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
        toolbarText.setText(text);
    }


}
