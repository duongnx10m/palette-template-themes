package com.duongnx.palettethemes.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.navigationdrawer.NavigationActivity;
import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.adapter.AdapterMain;

/**
 * Created by duongnx on 11/15/16.
 */

public class FrgColor extends FrgBase {

    private RecyclerView recylerView;
    private AdapterMain mAdapter;

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
        //mAdapter = new AdapterMain(mActivity, themeTypes);
        //mAdapter.setOnRecyclerItemClickListener(this);
        //mAdapter.setOnRecyclerItemClickListener(this);
        initListView();
        recylerView.setAdapter(mAdapter);
    }

    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recylerView.setLayoutManager(layoutManager);
    }


}
