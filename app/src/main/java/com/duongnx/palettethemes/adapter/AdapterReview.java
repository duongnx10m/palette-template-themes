package com.duongnx.palettethemes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.configs.ThemeType;
import com.duongnx.configs.utils.Utils;
import com.duongnx.palettethemes.R;
import com.duongnx.palettethemes.common.OnRecyclerItemClickListener;

/**
 * Created by duongnx on 11/4/16.
 */

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.VhMain> implements View.OnClickListener {


    private Context mContext;
    private ThemeType[] datas = {};
    private OnRecyclerItemClickListener onRecyclerItemClickListener;


    public AdapterReview(Context context, ThemeType[] datas) {
        super();
        this.datas = datas;
        this.mContext = context;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        onRecyclerItemClickListener = listener;
    }

    @Override
    public VhMain onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_preview, parent, false);
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
        private TextView tvPrimaryDark, tvPrimary, tvAccent;

        public VhMain(View itemView) {
            super(itemView);
            colorPrimaryDark = itemView.findViewById(R.id.colorPrimaryDark);
            colorPrimary = itemView.findViewById(R.id.colorPrimary);
            colorAccent = itemView.findViewById(R.id.colorAccent);

            tvPrimaryDark = (TextView) itemView.findViewById(R.id.tvPrimaryDark);
            tvPrimary = (TextView) itemView.findViewById(R.id.tvPrimary);
            tvAccent = (TextView) itemView.findViewById(R.id.tvAccent);
        }


        public void setContent(ThemeType themeType) {
            mContext.setTheme(themeType.getThemeId());
            int[] colors = Utils.getColorsFromTheme(mContext, themeType.getThemeId());
            colorAccent.setBackgroundColor(colors[0]);
            colorPrimary.setBackgroundColor(colors[1]);
            colorPrimaryDark.setBackgroundColor(colors[2]);

            tvAccent.setText("colorAccent: #" + Integer.toHexString(colors[0]).substring(2, 8));
            tvPrimary.setText("colorPrimary: #" + Integer.toHexString(colors[1]).substring(2, 8));
            tvPrimaryDark.setText("colorPrimaryDark: #" + Integer.toHexString(colors[2]).substring(2, 8));
        }


    }
}
