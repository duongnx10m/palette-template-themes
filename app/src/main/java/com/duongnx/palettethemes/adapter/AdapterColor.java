package com.duongnx.palettethemes.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.common.OnRecyclerItemClickListener;
import com.duongnx.palettethemes.models.ItemColor;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/4/16.
 */

public class AdapterColor extends RecyclerView.Adapter<AdapterColor.VhMain> implements View.OnClickListener {

    private final int COLOR_HEADER = 0;
    private final int COLOR_ROW = 1;
    private Context mContext;
    private ArrayList<ItemColor> datas = new ArrayList();
    private OnRecyclerItemClickListener onRecyclerItemClickListener;


    public AdapterColor(Context context, ArrayList<ItemColor> datas) {
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
        if (viewType == COLOR_HEADER)
            view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_color_header, parent, false);
        else
            view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_color, parent, false);
        view.setOnClickListener(this);
        return new VhMain(view);
    }

    @Override
    public void onBindViewHolder(VhMain holder, int position) {
        ItemColor data = datas.get(position);
        holder.itemView.setTag(position);
        holder.setContent(data, position);
    }

    public ItemColor getItem(int position) {
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

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? COLOR_HEADER : COLOR_ROW;
    }

    public class VhMain extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView tvName, tvValue;

        public VhMain(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvValue = (TextView) itemView.findViewById(R.id.tvValue);
        }

        public void setContent(ItemColor itemColor, int position) {
            if (position >= 1 && position < 5) {
                tvName.setTextColor(Color.BLACK);
                tvValue.setTextColor(Color.BLACK);
            } else {
                tvName.setTextColor(Color.WHITE);
                tvValue.setTextColor(Color.WHITE);
            }
            tvName.setText(itemColor.getName());
            tvValue.setText("#" + Integer.toHexString(itemColor.getColor()).substring(2, 7));
            itemView.setBackgroundColor(itemColor.getColor());
        }


    }
}
