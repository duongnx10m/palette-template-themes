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
import com.duongnx.palettethemes.adapter.AdapterReview;
import com.duongnx.palettethemes.common.OnRecyclerItemClickListener;
import com.duongnx.scrolling.ScrollingActivity;

/**
 * Created by duongnx on 11/14/16.
 */

public class FrgPreview extends FrgBase implements OnRecyclerItemClickListener {

    private final ThemeType[] themeTypes = {ThemeType.RED, ThemeType.INDIGO};
    private RecyclerView recylerView;
    private AdapterReview mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_color, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recylerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        mAdapter = new AdapterReview(mActivity, themeTypes);
        mAdapter.setOnRecyclerItemClickListener(this);
        initListView();
        recylerView.setAdapter(mAdapter);
    }

    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recylerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        ThemeType themeType = mAdapter.getItem(position);
        GApplication.getInstance().setThemeType(themeType);
        Intent intent = new Intent(mActivity, ScrollingActivity.class);
        startActivity(intent);
    }
}
