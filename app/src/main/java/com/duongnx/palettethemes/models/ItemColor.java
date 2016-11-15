package com.duongnx.palettethemes.models;

import com.duongnx.configs.ThemeType;

/**
 * Created by duongnx on 11/15/16.
 */

public class ItemColor {
    private String name;
    private int color;


    public ItemColor(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


}
