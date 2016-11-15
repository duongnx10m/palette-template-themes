package com.duongnx.palettethemes.fragments;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.adapter.AdapterColor;
import com.duongnx.palettethemes.models.ItemColor;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/15/16.
 */

public class FrgColor extends FrgBase {
    private RecyclerView recylerView;
    private AdapterColor mAdapter;
    private int arrColorRes = R.array.color_reds;

    public static FrgColor init(int colors) {
        FrgColor frgColor = new FrgColor();
        frgColor.setArrColorRes(colors);
        return frgColor;
    }

    public void setArrColorRes(int arrColorRes) {
        this.arrColorRes = arrColorRes;
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
        TypedArray typedArray = mActivity.getResources().obtainTypedArray(R.array.color_names);
        TypedArray typedArray1 = mActivity.getResources().obtainTypedArray(arrColorRes);
        for (int i = 0; i < typedArray.length(); i++) {
            int color = typedArray1.getColor(i, Color.BLACK);
            String name = typedArray.getString(i);
            itemColors.add(new ItemColor(name, color));
        }
        ItemColor itemColor = new ItemColor(itemColors.get(5).getName(), itemColors.get(5).getColor());
        itemColors.add(0, itemColor);
        typedArray.recycle();
        typedArray1.recycle();
        return itemColors;
    }

    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recylerView.setLayoutManager(layoutManager);
    }


}
