package com.xcooper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.xcooper.R;
import com.xcooper.view.CircleImg;

import java.util.List;
import java.util.Map;

/**
 * ���ձ��������б�������
 */
public class XiangmuChengyuanadapter extends MyBaseAdapter {

    List<Map<String, String>> list;
    Context context;

    public XiangmuChengyuanadapter(List<Map<String, String>> list, Context context) {
        super(context, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chengyuan_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.item_chengyuan_name);
            holder.img = (CircleImg) convertView.findViewById(R.id.item_chengyuan_img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Map<String, String> info = list.get(position);
        //���û��������
        holder.name.setText(info.get("name"));
        //���û��������
//        holder.img.setImageResource(info.get("img"));

        return convertView;
    }

    class ViewHolder {

        CircleImg img;      //��������
        TextView name;     //��������

    }
}
