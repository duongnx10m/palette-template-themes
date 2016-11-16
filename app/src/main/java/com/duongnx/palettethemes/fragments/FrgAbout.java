package com.duongnx.palettethemes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.configs.utils.Utils;
import com.duongnx.palettethemes.R;


/**
 * Created by duongnx on 11/12/16.
 */

public class FrgAbout extends FrgBase implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_about, container, false);
        mRootView.findViewById(R.id.btFeedback).setOnClickListener(this);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.setTitle("About");
        Utils.setTextWithLinks((TextView) mRootView.findViewById(R.id.tvContent), Utils.fromHtml(getString(R.string.application_info_text, Utils.getVersionName(mActivity))));
        Utils.setTextWithLinks((TextView) mRootView.findViewById(R.id.tvDev), Utils.fromHtml(getString(R.string.developer_info_text)));
    }

    @Override
    public void onClick(View view) {
        Utils.openEmail(mActivity, "duongnguyenxuan10m@gmail.com");
    }
}
