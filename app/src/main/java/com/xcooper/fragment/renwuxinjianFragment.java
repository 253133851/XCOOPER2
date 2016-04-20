package com.xcooper.fragment;

import android.view.View;
import android.widget.EditText;
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
    TextView renwu_add_submit;

    public void Init_View(View view) {

        renwu_add_submit = (TextView) view.findViewById(R.id.renwu_add_submit);
        renwu_add_info = (EditText) view.findViewById(R.id.renwu_add_info);
        renwu_add_name = (EditText) view.findViewById(R.id.renwu_add_name);

    }

    public void Init_Data() {
        setTitle(null);
        setNoFloatButtons(true);
    }

    public void Init_Listener() {
        addClick(renwu_add_submit);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.renwu_add_submit:
                AddTask();
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
