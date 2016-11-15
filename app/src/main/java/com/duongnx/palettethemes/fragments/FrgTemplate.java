package com.duongnx.palettethemes.fragments;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.navigationdrawer.NavigationActivity;
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
        for (int i = 0; i < 6; i++) {
            itemTemplates.add(new ItemTemplate());
        }
        if (mAdapter == null) {
            mAdapter = new AdapterTemplate(mActivity, itemTemplates);
            mAdapter.setOnRecyclerItemClickListener(this);
        }
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(mActivity, ScrollingActivity.class);
                break;
            case 1:
                intent = new Intent(mActivity, NavigationActivity.class);
                break;
        }
        if (intent != null)
            mActivity.startActivity(intent);
    }
}
