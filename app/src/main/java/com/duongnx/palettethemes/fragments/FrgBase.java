package com.duongnx.palettethemes.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.duongnx.palettethemes.MainActivity;

/**
 * Created by duongnx on 11/14/16.
 */

public class FrgBase extends Fragment {
    protected View mRootView;
    protected MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) getActivity();
    }
}
