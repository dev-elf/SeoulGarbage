package com.dev_elf.seoul.seoulgarbage.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.R;
import com.dev_elf.seoul.seoulgarbage.models.GarbageTip;

import java.util.ArrayList;

/**
 * Created by dnay2 on 2016-09-06.
 */
public class GarbageTipAdapter extends BaseAdapter {

    private static final int MOVE_U_C = R.anim.move_u_c;
    private static final int MOVE_C_U = R.anim.move_c_u;
    Animation show, hide;
    ArrayList<GarbageTip> items;
    Context context;

    public GarbageTipAdapter(Context context, ArrayList<GarbageTip> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if (items != null) return items.size();
        else return 0;
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        LinearLayout tipLayer;
        TextView tipTitle;
        TextView tipContents;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        show = AnimationUtils.loadAnimation(context.getApplicationContext(), MOVE_U_C);
        hide = AnimationUtils.loadAnimation(context.getApplicationContext(), MOVE_C_U);
        View convertView = view;
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.b_activity_card3_item, null);
            holder = new ViewHolder();
            holder.tipLayer = (LinearLayout) convertView.findViewById(R.id.tipLayer);
            holder.tipTitle = (TextView) convertView.findViewById(R.id.tipTitle);
            holder.tipContents = (TextView) convertView.findViewById(R.id.tipContents);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        GarbageTip item = items.get(i);

        holder.tipTitle.setText(item.getTitle());
        holder.tipContents.setText(item.getContents());

        holder.tipLayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.tipContents.getVisibility() == View.VISIBLE) {
                    holder.tipContents.startAnimation(hide);
                    holder.tipContents.setVisibility(View.GONE);
                } else {
                    holder.tipContents.startAnimation(show);
                    holder.tipContents.setVisibility(View.VISIBLE);
                }
            }
        });

        return convertView;
    }


}
