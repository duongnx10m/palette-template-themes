package com.duongnx.palettethemes.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.adapter.AdapterTemplate;
import com.duongnx.palettethemes.common.OnRecyclerItemClickListener;
import com.duongnx.palettethemes.models.ItemTemplate;
import com.duongnx.scrolling.ScrollingActivity;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/15/16.
 */

public class FrgTemplate extends FrgBase implements OnRecyclerItemClickListener {

    private RecyclerView recyclerView;
    private AdapterTemplate mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_template, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<ItemTemplate> itemTemplates = new ArrayList<>();
        itemTemplates.add(new ItemTemplate("Red", ThemeType.RED));
        itemTemplates.add(new ItemTemplate("Indigo", ThemeType.INDIGO));
        itemTemplates.add(new ItemTemplate("Pink", ThemeType.PINK));
        itemTemplates.add(new ItemTemplate("Purple", ThemeType.PURPLE));
        itemTemplates.add(new ItemTemplate("Deep Purple", ThemeType.DEEP_PURPLE));
        itemTemplates.add(new ItemTemplate("Blue", ThemeType.BLUE));
        itemTemplates.add(new ItemTemplate("Light Blue", ThemeType.LIGHT_BLUE));
        itemTemplates.add(new ItemTemplate("Cyan", ThemeType.CYAN));
        itemTemplates.add(new ItemTemplate("Teal", ThemeType.TEAL));
        itemTemplates.add(new ItemTemplate("Green", ThemeType.GREEN));
        itemTemplates.add(new ItemTemplate("Light Green", ThemeType.LIGHT_GREEN));
        itemTemplates.add(new ItemTemplate("Lime", ThemeType.LIME));
        itemTemplates.add(new ItemTemplate("Yello", ThemeType.YELLO));
        itemTemplates.add(new ItemTemplate("Amber", ThemeType.AMBER));
        itemTemplates.add(new ItemTemplate("Orange", ThemeType.ORANGE));
        itemTemplates.add(new ItemTemplate("Deep Orange", ThemeType.DEEP_ORANGE));
        itemTemplates.add(new ItemTemplate("Brown", ThemeType.BROWN));
        itemTemplates.add(new ItemTemplate("Grey", ThemeType.GREY));
        itemTemplates.add(new ItemTemplate("Blue Grey", ThemeType.BLUE_GREY));

        if (mAdapter == null) {
            mAdapter = new AdapterTemplate(mActivity, itemTemplates);
            mAdapter.setOnRecyclerItemClickListener(this);
        }
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        ItemTemplate itemTemplate = mAdapter.getItem(position);
        GApplication.getInstance().setThemeType(itemTemplate.getThemeType());
        Intent intent = new Intent(mActivity, ScrollingActivity.class);
        mActivity.startActivity(intent);
    }


}
