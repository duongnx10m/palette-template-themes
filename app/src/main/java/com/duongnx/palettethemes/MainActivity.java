package com.duongnx.palettethemes;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenuItemView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.configs.utils.Utils;
import com.duongnx.navigationdrawer.NavigationActivity;
import com.duongnx.navigationdrawer.wigets.NavigationHeaderView;
import com.duongnx.palettethemes.adapter.AdapterMain;
import com.duongnx.scrolling.ScrollingActivity;

/**
 * Created by duongnx on 11/14/16.
 */

public class MainActivity extends AppCompatActivity implements AdapterMain.OnRecyclerItemClickListener {

    private final ThemeType[] themeTypes = {ThemeType.RED, ThemeType.INDIGO};
    private RecyclerView recylerView;
    private AdapterMain mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerView = (RecyclerView) findViewById(R.id.recylerView);
        mAdapter = new AdapterMain(this, themeTypes);
        mAdapter.setOnRecyclerItemClickListener(this);
        initListView();
        recylerView.setAdapter(mAdapter);
    }


    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recylerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        ThemeType themeType = mAdapter.getItem(position);
        GApplication.getInstance().setThemeType(themeType);
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}
