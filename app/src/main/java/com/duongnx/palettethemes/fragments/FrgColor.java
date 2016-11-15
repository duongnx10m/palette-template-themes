package com.duongnx.palettethemes.fragments;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.adapter.AdapterColor;
import com.duongnx.palettethemes.common.OnRecyclerItemClickListener;
import com.duongnx.palettethemes.models.ItemColor;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/15/16.
 */

public class FrgColor extends FrgBase {
    private RecyclerView recylerView;
    private AdapterColor mAdapter;
    private ThemeType themeType = ThemeType.RED;
    private int arrColorRes = R.array.color_reds;

    public static FrgColor init(int colors) {
        FrgColor frgColor = new FrgColor();
        frgColor.setArrColorRes(colors);
        frgColor.updateTheme(colors);
        return frgColor;
    }

    public void setArrColorRes(int arrColorRes) {
        this.arrColorRes = arrColorRes;
    }

    public void updateTheme(int arrColorRes) {
        switch (arrColorRes) {
            case R.array.color_reds:
                themeType = ThemeType.RED;
                break;
            case R.array.color_indigos:
                themeType = ThemeType.INDIGO;
                break;
            case R.array.color_pinks:
                themeType = ThemeType.PINK;
                break;
            case R.array.color_purples:
                themeType = ThemeType.PURPLE;
                break;
            case R.array.color_deeppurples:
                themeType = ThemeType.DEEP_PURPLE;
                break;
            case R.array.color_blues:
                themeType = ThemeType.BLUE;
                break;
            case R.array.color_lightblues:
                themeType = ThemeType.LIGHT_BLUE;
                break;
            case R.array.color_cyans:
                themeType = ThemeType.CYAN;
                break;
            case R.array.color_teals:
                themeType = ThemeType.TEAL;
                break;
            case R.array.color_greens:
                themeType = ThemeType.GREEN;
                break;
            case R.array.color_lightgreens:
                themeType = ThemeType.LIGHT_GREEN;
                break;
            case R.array.color_limes:
                themeType = ThemeType.LIME;
                break;
            case R.array.color_yellows:
                themeType = ThemeType.YELLO;
                break;
            case R.array.color_ambers:
                themeType = ThemeType.AMBER;
                break;
            case R.array.color_oranges:
                themeType = ThemeType.ORANGE;
                break;
            case R.array.color_deeporanges:
                themeType = ThemeType.DEEP_ORANGE;
                break;
            case R.array.color_browns:
                themeType = ThemeType.BROWN;
                break;
            case R.array.color_greys:
                themeType = ThemeType.GREY;
                break;
            case R.array.color_bluegreys:
                themeType = ThemeType.BLUE_GREY;
                break;
            default:
                themeType = ThemeType.PINK;
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_color_palette, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recylerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        if (mAdapter == null) {
            mAdapter = new AdapterColor(mActivity, getDatas());
        }
        initListView();
        recylerView.setAdapter(mAdapter);
    }

    private ArrayList<ItemColor> getDatas() {
        ArrayList<ItemColor> itemColors = new ArrayList<>();
        TypedArray typedArray1 = mActivity.getResources().obtainTypedArray(arrColorRes);
        for (int i = 0; i < typedArray1.length(); i++) {
            int color = typedArray1.getColor(i, Color.BLACK);
            itemColors.add(new ItemColor(mActivity.getColorNames()[i], color));
        }
        ItemColor itemColor = new ItemColor(itemColors.get(5).getName(), itemColors.get(5).getColor());
        itemColors.add(0, itemColor);
        typedArray1.recycle();
        return itemColors;
    }

    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recylerView.setLayoutManager(layoutManager);
    }

    public ThemeType getThemeType() {
        return themeType;
    }
}
