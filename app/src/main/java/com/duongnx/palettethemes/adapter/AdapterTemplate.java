package com.duongnx.palettethemes.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.configs.utils.Utils;
import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.common.OnRecyclerItemClickListener;
import com.duongnx.palettethemes.models.ItemColor;
import com.duongnx.palettethemes.models.ItemTemplate;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/4/16.
 */

public class AdapterTemplate extends RecyclerView.Adapter<AdapterTemplate.VhMain> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<ItemTemplate> datas = new ArrayList();
    private OnRecyclerItemClickListener onRecyclerItemClickListener;


    public AdapterTemplate(Context context, ArrayList<ItemTemplate> datas) {
        super();
        this.datas = datas;
        this.mContext = context;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        onRecyclerItemClickListener = listener;
    }

    @Override
    public VhMain onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_template, parent, false);
        view.setOnClickListener(this);
        return new VhMain(view);
    }

    @Override
    public void onBindViewHolder(VhMain holder, int position) {
        ItemTemplate data = datas.get(position);
        holder.itemView.setTag(position);
        holder.setContent(data, position);
    }

    public ItemTemplate getItem(int position) {
        if (position >= 0 && position < datas.size())
            return datas.get(position);
        else
            return null;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View view) {
        if (onRecyclerItemClickListener != null) {
            onRecyclerItemClickListener.onRecyclerItemClick((Integer) view.getTag());
        }
    }

    public class VhMain extends RecyclerView.ViewHolder {
        private View itemView, lnHeader, rlContent, rlCircle;
        private TextView tvName;

        public VhMain(View itemView) {
            super(itemView);
            this.itemView = itemView;
            lnHeader = itemView.findViewById(R.id.lnHeader);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            rlContent = itemView.findViewById(R.id.rlContent);
            rlCircle = itemView.findViewById(R.id.rlCircle);
        }

        public void setContent(ItemTemplate itemTemplate, int position) {
            mContext.setTheme(itemTemplate.getThemeType().getThemeId());
            int[] colors = Utils.getColorsFromTheme(mContext, itemTemplate.getThemeType().getThemeId());
            tvName.setText(itemTemplate.getName());
            lnHeader.setBackgroundColor(colors[2]);
            rlContent.setBackgroundColor(colors[1]);
            Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.shape_circle_red_a200);
            drawable.setColorFilter(colors[0], PorterDuff.Mode.SRC_ATOP);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                rlCircle.setBackgroundDrawable(drawable);
            else rlCircle.setBackground(drawable);

        }


    }
}
