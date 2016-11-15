package com.duongnx.palettethemes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.duongnx.palettethemes.fragments.FrgReview;

/**
 * Created by duongnx on 8/17/2016.
 */
public class AdapterPagerReview extends FragmentPagerAdapter {


    public AdapterPagerReview(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return new FrgReview();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Red 500";
            default:
                return "Indigo 500";
        }
    }

}
