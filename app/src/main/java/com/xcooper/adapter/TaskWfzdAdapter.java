package com.xcooper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xcooper.Constant;
import com.xcooper.R;
import com.xcooper.view.CircleImg;

import java.util.List;
import java.util.Map;

/**
 * 今日被货单的列表适配器
 */
public class TaskWfzdAdapter extends MyBaseAdapter {

    List<Map<String, String>> list;
    Context context;

    public TaskWfzdAdapter(List<Map<String, String>> list, Context context) {
        super(context, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.wofuzede_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tv_task_name);
            holder.xiangmu = (TextView) convertView.findViewById(R.id.tv_task_xiangmu);
            holder.date = (TextView) convertView.findViewById(R.id.tv_task_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        try {
            Map<String, String> info = list.get(position);
            holder.name.setText(info.get("name"));
            holder.xiangmu.setText(Constant.projectMap.get(Integer.parseInt(info.get("xiangmu"))).getProject_NAME().substring(5,10));
            holder.date.setText(info.get("date"));
        } catch (java.lang.NullPointerException e) {

        }
        return convertView;
    }

    class ViewHolder {

        TextView name;
        TextView xiangmu;
        TextView date;

    }
}
