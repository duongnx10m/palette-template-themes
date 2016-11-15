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

    private int[] colors = {
            R.array.color_reds, R.array.color_indigos,
            R.array.color_pinks, R.array.color_purples,
            R.array.color_deeppurples, R.array.color_blues,
            R.array.color_lightblues, R.array.color_cyans,
            R.array.color_teals, R.array.color_greens,
            R.array.color_lightgreens, R.array.color_limes,
            R.array.color_yellows, R.array.color_ambers,
            R.array.color_oranges, R.array.color_deeporanges,
            R.array.color_browns, R.array.color_greys,
            R.array.color_bluegreys
    };

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
            case 3:
                return "purples";
            case 4:
                return "Deep purples";
            case 5:
                return "Blue";
            case 6:
                return "Light Blue";
            case 7:
                return "Cyan";
            case 8:
                return "Teal";
            case 9:
                return "Green";
            case 10:
                return "Light Green";
            case 11:
                return "Lime";
            case 12:
                return "Yellow";
            case 13:
                return "Amber";
            case 14:
                return "Orange";
            case 15:
                return "Deep Orange";
            case 16:
                return "Brown";
            case 17:
                return "Grey";
            case 18:
                return "Blue Grey";
            default:
                return "";
        }
    }

}
