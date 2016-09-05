package com.dev_elf.seoul.seoulgarbage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;
import com.dev_elf.seoul.seoulgarbage.adapters.NavigationDrawerAdapter;
import com.dev_elf.seoul.seoulgarbage.interfaces.NavigationDrawer;

/**
 * Created by dnay2 on 2016-09-04.
 */
public class MainNav extends SActivity implements NavigationDrawer{


    private static final int[] cardLayout = {
        0
    };

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    View mDrawerLeft;
    ListView mMenuList;
    TextView userAddress;

    private boolean isDrawerOpen = false;


    long pressedTime = 0;
    @Override
    public void onBackPressed() {
        if(isDrawerOpen){
            closeDrawer();
        } else if(pressedTime+ 2000 < System.currentTimeMillis()) {
            pressedTime = System.currentTimeMillis();
            Toast.makeText(MainNav.this, "종료키를 한번 더 눌러주세요", Toast.LENGTH_SHORT).show();
        } else super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.a_navigation);
        initDrawer();
        initCard();
    }

    private void initDrawer(){
        mDrawerLeft = findViewById(R.id.drawerMenu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            @Override
            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                isDrawerOpen = true;
                setToolbarText("쓰레기버리기 메뉴를 골라주세요");
            }

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                isDrawerOpen = false;
                setToolbarText("서울쓰레기");
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        initDrawerMenu();
    }

    private void initDrawerMenu(){
        mMenuList = (ListView) findViewById(R.id.menuList);
        userAddress = (TextView) findViewById(R.id.userAddress);

        mMenuList.setAdapter(new NavigationDrawerAdapter(MainNav.this));
        mMenuList.setOnItemClickListener(menuHandler);
        userAddress.setText("당신의 위치 내 마음속");
    }

    private void initCard(){

    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



    @Override
    public void closeDrawer() {
        if(mDrawerLayout != null && mDrawerLeft != null && isDrawerOpen) mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void openDrawer() {
        if(mDrawerLayout != null && mDrawerLeft != null) mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    AdapterView.OnItemClickListener menuHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = null;
            switch (position){
                case 0: intent = new Intent(MainNav.this, BActivityCard1Activity.class);
                    break;
                case 1: intent = new Intent(MainNav.this, BActivityCard2Activity.class);
                    break;
                case 2: intent = new Intent(MainNav.this, BActivityCard3Activity.class);
                    break;
                case 3: intent = new Intent(MainNav.this, BActivityCard4Activity.class);
                    break;
                case 4: intent = new Intent(MainNav.this, BActivityCard5Activity.class);
                    break;
            }
            startActivity(intent);

        }
    };

    public void clickCard1(View v){
        Intent intent = new Intent(MainNav.this, BActivityCard1Activity.class);
        startActivity(intent);
    }
    public void clickCard2(View v){
        Intent intent = new Intent(MainNav.this, BActivityCard2Activity.class);
        startActivity(intent);
    }
    public void clickCard3(View v){
        Intent intent = new Intent(MainNav.this, BActivityCard3Activity.class);
        startActivity(intent);
    }
    public void clickCard4(View v){
        Intent intent = new Intent(MainNav.this, BActivityCard4Activity.class);
        startActivity(intent);
    }
    public void clickCard5(View v){
        Intent intent = new Intent(MainNav.this, BActivityCard5Activity.class);
        startActivity(intent);
    }

}
