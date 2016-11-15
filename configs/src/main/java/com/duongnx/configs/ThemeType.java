package com.duongnx.configs;

import android.content.res.TypedArray;
import android.graphics.Color;

import java.io.Serializable;

/**
 * Created by duongnx on 11/14/16.
 */

public enum ThemeType {
    RED(R.style.AppThemeRed_NoActionBar),
    INDIGO(R.style.AppThemeIndigo_NoActionBar),
    PINK(R.style.AppThemePink_NoActionBar),
    PURPLE(R.style.AppThemePurple_NoActionBar),
    DEEP_PURPLE(R.style.AppThemeDeeppurple_NoActionBar),
    BLUE(R.style.AppThemeBlue_NoActionBar),
    LIGHT_BLUE(R.style.AppThemeLightBlue_NoActionBar),
    CYAN(R.style.AppThemeCyan_NoActionBar),
    TEAL(R.style.AppThemeTeal_NoActionBar),
    GREEN(R.style.AppThemeGreen_NoActionBar),
    LIGHT_GREEN(R.style.AppThemeLightGreen_NoActionBar),
    LIME(R.style.AppThemeLime_NoActionBar),
    YELLO(R.style.AppThemeYellow_NoActionBar),
    AMBER(R.style.AppThemeAmber_NoActionBar),
    ORANGE(R.style.AppThemeOrange_NoActionBar),
    DEEP_ORANGE(R.style.AppThemeDeepOrange_NoActionBar),
    BROWN(R.style.AppThemeBrown_NoActionBar),
    GREY(R.style.AppThemeGrey_NoActionBar),
    BLUE_GREY(R.style.AppThemeBlueGrey_NoActionBar),;

    private int themeId;

    ThemeType(int themeId) {
        this.themeId = themeId;
    }

    public int getThemeId() {
        return themeId;
    }
}
