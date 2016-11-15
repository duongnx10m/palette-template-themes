package com.duongnx.palettethemes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.duongnx.palettethemes.fragments.FrgColor;

/**
 * Created by duongnx on 8/17/2016.
 */
public class AdapterPagerColor extends FragmentPagerAdapter {


    public AdapterPagerColor(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return new FrgColor();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Red";
            default:
                return "Indigo";
        }
    }

}
