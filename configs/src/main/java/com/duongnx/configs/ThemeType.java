package com.duongnx.configs;

import java.io.Serializable;

/**
 * Created by duongnx on 11/14/16.
 */

public enum ThemeType {
    RED(R.style.AppThemeRed_NoActionBar, R.color.red_500, R.color.red_700, R.color.indigo_A200),
    INDIGO(R.style.AppThemeIndigo_NoActionBar, R.color.indigo_500, R.color.indigo_700, R.color.pink_A200);

    private int themeId, colorPrimary, colorPrimaryDark, colorAccent;

    ThemeType(int themeId, int colorPrimary, int colorPrimaryDark, int colorAccent) {
        this.themeId = themeId;
        this.colorPrimary = colorPrimary;
        this.colorPrimaryDark = colorPrimaryDark;
        this.colorAccent = colorAccent;

    }

    public int getThemeId() {
        return themeId;
    }

    public int getColorPrimary() {
        return colorPrimary;
    }

    public int getColorPrimaryDark() {
        return colorPrimaryDark;
    }

    public int getColorAccent() {
        return colorAccent;
    }

}
