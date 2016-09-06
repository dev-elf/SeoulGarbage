package com.dev_elf.seoul.seoulgarbage.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev_elf.seoul.seoulgarbage.R;
import com.dev_elf.seoul.seoulgarbage.models.MenuItem;

import java.util.ArrayList;

/**
 * Created by dnay2 on 2016-09-04.
 */
public class NavigationDrawerAdapter extends BaseAdapter {

    ArrayList<MenuItem> items;
    Context context;

    public NavigationDrawerAdapter(Context context, ArrayList<MenuItem> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        ImageView menuImg;
        TextView menuName;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ViewHolder holder;
        if(v == null){
            v = View.inflate(context, R.layout.a_navigation_drawer_item, null);
            holder = new ViewHolder();
            holder.menuImg = (ImageView) v.findViewById(R.id.menuImg);
            holder.menuName = (TextView) v.findViewById(R.id.menuName);
            v.setTag(holder);
        } else{
            holder = (ViewHolder) v.getTag();
        }

        MenuItem item = items.get(i);
        holder.menuImg.setImageResource(item.getMenuImg());
        holder.menuName.setText(item.getMenuName());

        return v;
    }


}
