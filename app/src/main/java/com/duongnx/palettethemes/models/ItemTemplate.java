package com.duongnx.palettethemes.models;

import com.duongnx.configs.ThemeType;

/**
 * Created by duongnx on 11/15/16.
 */

public class ItemTemplate {
    private String name;
    private ThemeType themeType;

    public ItemTemplate(String name, ThemeType themeType) {
        this.name = name;
        this.themeType = themeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThemeType getThemeType() {
        return themeType;
    }

    public void setThemeType(ThemeType themeType) {
        this.themeType = themeType;
    }
}
