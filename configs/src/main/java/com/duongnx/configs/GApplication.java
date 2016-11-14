package com.duongnx.configs;

import android.app.Application;

/**
 * Created by duongnx on 11/14/16.
 */

public class GApplication extends Application {

    private ThemeType themeType = ThemeType.RED;
    static GApplication instance;

    public static GApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //updateThemes();
    }


    public ThemeType getThemeType() {
        return themeType;
    }

    public void setThemeType(ThemeType themeType) {
        this.themeType = themeType;
    }
}
