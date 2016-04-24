package com.xcooper.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.MyAsynctask;
import com.xcooper.R;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hh on 2016.4.12.
 */
public class renwuxinjianFragment extends MyFragment {


    public static renwuxinjianFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getRenwuxinjianFragment();
        setLAYOUT(R.layout.renwuxinjian);
        Fragment.setFROM((Integer) getArguments().get("from"));
    }

    EditText renwu_add_name, renwu_add_info;
    TextView renwu_add_submit, tv_renwu_set_guanzuren, tv_renwu_set_pxiangmu, tv_renwu_set_ren8shijian, tv_chengyuan_select, tv_fuzeren_cancel, tv_xiangmu_select;
    RelativeLayout renwu_add_xiangmu_select, renwu_add_fuzeren_select, renwu_add_guanzuren_add;

    public void Init_View(View view) {

        renwu_add_submit = (TextView) view.findViewById(R.id.renwu_add_submit);
        tv_renwu_set_guanzuren = (TextView) view.findViewById(R.id.tv_renwu_set_guanzuren);
        tv_renwu_set_pxiangmu = (TextView) view.findViewById(R.id.tv_renwu_set_pxiangmu);
        tv_renwu_set_ren8shijian = (TextView) view.findViewById(R.id.tv_renwu_set_ren8shijian);
        tv_chengyuan_select = (TextView) view.findViewById(R.id.tv_chengyuan_Add);
        tv_fuzeren_cancel = (TextView) view.findViewById(R.id.tv_fuzeren_cancel);
        tv_xiangmu_select = (TextView) view.findViewById(R.id.tv_xiangmu_select);
        renwu_add_info = (EditText) view.findViewById(R.id.renwu_add_info);
        renwu_add_name = (EditText) view.findViewById(R.id.renwu_add_name);
        renwu_add_xiangmu_select = (RelativeLayout) view.findViewById(R.id.renwu_add_xiangmu_select);
        renwu_add_fuzeren_select = (RelativeLayout) view.findViewById(R.id.renwu_add_fuzeren_select);
        renwu_add_guanzuren_add = (RelativeLayout) view.findViewById(R.id.renwu_add_guanzuren_add);

    }

    public void Init_Data() {
        setTitle(null);
        setNoFloatButtons(true);
    }

    public void Init_Listener() {
        addClick(renwu_add_submit);
        addClick(tv_renwu_set_guanzuren);
        addClick(tv_renwu_set_pxiangmu);
        addClick(tv_renwu_set_ren8shijian);
        addClick(tv_chengyuan_select);
        addClick(tv_xiangmu_select);
        addClick(tv_fuzeren_cancel);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.renwu_add_submit:
                AddTask();
                break;
            case R.id.tv_renwu_set_guanzuren:
                renwu_add_guanzuren_add.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_renwu_set_pxiangmu:
                renwu_add_xiangmu_select.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_renwu_set_ren8shijian:
                renwu_add_fuzeren_select.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_chengyuan_Add:
                renwu_add_guanzuren_add.setVisibility(View.GONE);
                break;
            case R.id.tv_xiangmu_select:
                renwu_add_xiangmu_select.setVisibility(View.GONE);
                break;
            case R.id.tv_fuzeren_cancel:
                renwu_add_fuzeren_select.setVisibility(View.GONE);
                break;
        }
    }

    private void AddTask() {
        Method_Center.hideSoftInput();
        Map<String, String> map = new HashMap<String, String>();
        map.put("listId", "1");
        map.put("projectId", "1");
        map.put("createId", "1");
        map.put("exeId", "1");
        map.put("taskName", renwu_add_name.getText().toString());
        map.put("endDatetime", "2016-01-06 00:00:00");
        map.put("taskInfo", renwu_add_info.getText().toString());
        new MyAsynctask(map, ENV.URL_ADD_TASK) {
            public void OK(JSONObject code) {
                Method_Center.show_Toast("添加成功", true);
            }
        }.execute();
    }

}
