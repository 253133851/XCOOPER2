package com.xcooper.fragment;

import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.MyAsynctask;
import com.xcooper.R;
import com.xcooper.adapter.XiangmuChengyuanAdapter;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hh on 2016.4.9.
 */
public class xiangmuAddFragment extends MyFragment {

    public static xiangmuAddFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getxiangmuAddFragment();
        setLAYOUT(R.layout.xiangmu_xinjian);
    }

    LinearLayout chengyuan_add_test_click;
    RelativeLayout chengyuan_Add;
    TextView chengyuan_Add_tv, xiangmu_add_submit;
    EditText xiangmu_add_name;
    GridView gv_xiangmu_chengyuan;


    public void Init_View(View view) {

//        chengyuan_add_test_click = (LinearLayout) view.findViewById(R.id.chengyuan_add_test_click);
        chengyuan_Add = (RelativeLayout) view.findViewById(R.id.rl_chengyuanAdd);
        chengyuan_Add_tv = (TextView) view.findViewById(R.id.tv_chengyuan_Add);
        xiangmu_add_submit = (TextView) view.findViewById(R.id.xiangmu_add_submit);
        xiangmu_add_name = (EditText) view.findViewById(R.id.xiangmu_add_name);
        gv_xiangmu_chengyuan = (GridView) view.findViewById(R.id.gv_xiangmu_chengyuan);

        final List<Map<String, String>> chengyuanList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "成员" + i);
            chengyuanList.add(map);
        }
        Map<String, String> map = new HashMap<>();
        map.put("name", "新增成员");
        chengyuanList.add(map);

        gv_xiangmu_chengyuan.setAdapter(new XiangmuChengyuanAdapter(chengyuanList, Constant.activity));
        gv_xiangmu_chengyuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position + "  " + chengyuanList.size());
                if (position == (chengyuanList.size() - 1)) {
                    chengyuan_Add.setVisibility(View.VISIBLE);
                }
            }
        });
        gv_xiangmu_chengyuan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Method_Center.show_Toast(chengyuanList.get(position).get("name"), true);
                return false;
            }
        });
    }

    public void Init_Listener() {
//        addClick(chengyuan_add_test_click);
        addClick(chengyuan_Add_tv);
        addClick(xiangmu_add_submit);
    }

    public void Init_Data() {
        setTitle(null);
        setNoFloatButtons(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
//            case R.id.chengyuan_add_test_click:
////                Fragment_Center.loadchengyuanAdd();
//                chengyuan_Add.setVisibility(View.VISIBLE);
//                break;
            case R.id.tv_chengyuan_Add:
//                Fragment_Center.loadchengyuanAdd();
                chengyuan_Add.setVisibility(View.GONE);
                break;
            case R.id.xiangmu_add_submit:
                AddProject();
                break;
        }
    }

    private void AddProject() {
        Method_Center.hideSoftInput();
        Map<String, String> map = new HashMap<String, String>();
        map.put("memberIds", "1,2,3");
        map.put("projectName", xiangmu_add_name.getText().toString());
        map.put("projectInfo", "默认描述");
        map.put("type", "1");
        map.put("isHide", "-1");
        map.put("isReadOnly", "-1");
        new MyAsynctask(map, ENV.URL_ADD_PROJECT) {
            public void OK(JSONObject code) {
                Method_Center.show_Toast("添加成功", true);
            }
        }.execute();
    }

}
