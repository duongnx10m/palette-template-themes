package com.duongnx.configs;

import android.content.res.TypedArray;
import android.graphics.Color;

import java.io.Serializable;

/**
 * Created by duongnx on 11/14/16.
 */

public enum ThemeType {
    RED(R.style.AppThemeRed_NoActionBar),
    INDIGO(R.style.AppThemeIndigo_NoActionBar);

    private int themeId;

    ThemeType(int themeId) {
        this.themeId = themeId;
    }

    public int getThemeId() {
        return themeId;
    }
}
