package com.duongnx.palettethemes;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenuItemView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.configs.utils.Utils;
import com.duongnx.navigationdrawer.NavigationActivity;
import com.duongnx.navigationdrawer.wigets.NavigationHeaderView;

/**
 * Created by duongnx on 11/14/16.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnRed).setOnClickListener(this);
        findViewById(R.id.btnIndigo).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        switch (view.getId()) {
            case R.id.btnRed:
                GApplication.getInstance().setThemeType(ThemeType.RED);
                break;
            case R.id.btnIndigo:
                GApplication.getInstance().setThemeType(ThemeType.INDIGO);
                break;
        }
        startActivity(intent);
    }
}
