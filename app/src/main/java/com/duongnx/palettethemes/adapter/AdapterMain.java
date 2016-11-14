package com.duongnx.palettethemes.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.configs.utils.Utils;
import com.duongnx.palettethemes.R;

/**
 * Created by duongnx on 11/4/16.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.VhMain> implements View.OnClickListener {
    public interface OnRecyclerItemClickListener {
        void onRecyclerItemClick(int position);
    }

    private Context mContext;
    private ThemeType[] datas = {};
    private OnRecyclerItemClickListener onRecyclerItemClickListener;


    public AdapterMain(Context context, ThemeType[] datas) {
        super();
        this.datas = datas;
        this.mContext = context;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        onRecyclerItemClickListener = listener;
    }

    @Override
    public VhMain onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false);
        view.setOnClickListener(this);
        return new VhMain(view);
    }

    @Override
    public void onBindViewHolder(VhMain holder, int position) {
        ThemeType data = datas[position];
        holder.itemView.setTag(position);
        holder.setContent(data);
    }

    public ThemeType getItem(int position) {
        if (position >= 0 && position < datas.length)
            return datas[position];
        else
            return null;
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    @Override
    public void onClick(View view) {
        if (onRecyclerItemClickListener != null) {
            onRecyclerItemClickListener.onRecyclerItemClick((Integer) view.getTag());
        }
    }

    public class VhMain extends RecyclerView.ViewHolder {
        private View colorPrimaryDark, colorPrimary, colorAccent;


        public VhMain(View itemView) {
            super(itemView);
            colorPrimaryDark = itemView.findViewById(R.id.colorPrimaryDark);
            colorPrimary = itemView.findViewById(R.id.colorPrimary);
            colorAccent = itemView.findViewById(R.id.colorAccent);
        }


        public void setContent(ThemeType themeType) {
            mContext.setTheme(themeType.getThemeId());
            int[] colors = Utils.getColorsFromTheme(mContext, themeType.getThemeId());
            colorAccent.setBackgroundColor(colors[0]);
            colorPrimary.setBackgroundColor(colors[1]);
            colorPrimaryDark.setBackgroundColor(colors[2]);
            // Log.d("duongnx", "setContent:" + themeType.name() + themeType.getThemeId() + ";" + Integer.toHexString(colors[0]));
        }


    }
}
