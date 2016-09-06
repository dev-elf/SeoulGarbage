package com.dev_elf.seoul.seoulgarbage;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dnay2 on 2016-09-05.
 */
public class LaunchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_launch);

        new LaunchTask().execute();
    }


    class LaunchTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            SystemClock.sleep(3000);
            Intent intent = new Intent(LaunchActivity.this, MainNav.class);
            startActivity(intent);
            finish();
            return null;
        }
    }
}
