package com.xcooper.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;

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

    public void Init_View(View view) {

        chengyuan_add_test_click = (LinearLayout) view.findViewById(R.id.chengyuan_add_test_click);

    }

    public void Init_Listener() {
        addClick(chengyuan_add_test_click);
    }

    public void Init_Data() {
        setTitle("新增项目");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
            case R.id.chengyuan_add_test_click:
                Fragment_Center.loadchengyuanAdd();
                break;
        }
    }

}
