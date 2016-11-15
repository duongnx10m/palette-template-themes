package com.duongnx.palettethemes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.fragments.FrgColor;

/**
 * Created by duongnx on 8/17/2016.
 */
public class AdapterPagerColor extends FragmentPagerAdapter {

    private int[] colors = {R.array.color_reds, R.array.color_indigos, R.array.color_pinks};

    public AdapterPagerColor(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return FrgColor.init(colors[position]);
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Red";
            case 1:
                return "Indigo";
            case 2:
                return "Pink";
            default:
                return "";
        }
    }

}
