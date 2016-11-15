package com.duongnx.palettethemes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.adapter.AdapterPagerReview;
import com.duongnx.palettethemes.slidding.SlidingTabLayout;

/**
 * Created by duongnx on 11/15/16.
 */

public class FrgSliddingTabsReview extends FrgBase {
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private AdapterPagerReview mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_sliddingtabs, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        slidingTabLayout = (SlidingTabLayout) mRootView.findViewById(R.id.slidingTabLayout);
        viewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);

        if (mAdapter == null) {
            mAdapter = new AdapterPagerReview(getChildFragmentManager());
        }

        viewPager.setAdapter(mAdapter);
        slidingTabLayout.setViewPager(viewPager);
    }
}
