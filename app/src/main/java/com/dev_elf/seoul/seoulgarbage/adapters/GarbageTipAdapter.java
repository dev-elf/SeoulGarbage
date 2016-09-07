package com.dev_elf.seoul.seoulgarbage.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.R;
import com.dev_elf.seoul.seoulgarbage.models.GarbageTip;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by dnay2 on 2016-09-06.
 */
public class GarbageTipAdapter extends BaseAdapter implements Filterable {

    private static final int MOVE_U_C = R.anim.move_u_c;
    private static final int MOVE_C_U = R.anim.move_c_u;
    Animation show, hide;
    ArrayList<GarbageTip> items;
    ArrayList<GarbageTip> original;
    Context context;

    public GarbageTipAdapter(Context context, ArrayList<GarbageTip> items) {
        this.context = context;
        this.items = items;
        this.original = new ArrayList<>();
        this.original.addAll(items);
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

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<GarbageTip> FilteredArrList = new ArrayList<>();

                if (items == null) {
                    items = new ArrayList<>(original);
                }
                if (constraint == null || constraint.length() == 0) {
                    results.count = original.size();
                    results.values = original;
                } else {
                    constraint = constraint.toString().toLowerCase(Locale.KOREA);
                    for (GarbageTip data : original) {
                        String str = data.getTitle();
                        if (str.toLowerCase().startsWith(constraint.toString()) //검색어로 시작
                                || str.toLowerCase().equals(constraint.toString()) //검색어와 일치
                                || str.toLowerCase().contains(constraint) //검색어를 포함
                                ) {
                            FilteredArrList.add(new GarbageTip(
                                    data.getTitle(),
                                    data.getContents()));
                            Log.d("test", data.getTitle() +" is detected");
                        }
                    }
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                items = (ArrayList<GarbageTip>) results.values;
                notifyDataSetChanged();
            }

        };
    }
}
