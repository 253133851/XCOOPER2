package com.xcooper.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;


public abstract class MyBaseAdapter extends BaseAdapter{

    Context context;
    List list;

    public MyBaseAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
