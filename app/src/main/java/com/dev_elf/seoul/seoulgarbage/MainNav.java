package com.dev_elf.seoul.seoulgarbage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.View;

import com.dev_elf.seoul.seoulgarbage.acitivities.SActivity;
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

    private boolean isDrawerOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.a_navigation);
        initDrawer();
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
        ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isDrawerOpen = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                isDrawerOpen = false;
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
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
}
