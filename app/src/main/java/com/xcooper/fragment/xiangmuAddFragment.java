package com.xcooper.fragment;

import android.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    RelativeLayout chengyuan_Add;
    TextView chengyuan_Add_tv;

    public void Init_View(View view) {

        chengyuan_add_test_click = (LinearLayout) view.findViewById(R.id.chengyuan_add_test_click);
        chengyuan_Add = (RelativeLayout) view.findViewById(R.id.rl_chengyuanAdd);
        chengyuan_Add_tv = (TextView) view.findViewById(R.id.tv_chengyuan_Add);

    }

    public void Init_Listener() {
        addClick(chengyuan_add_test_click);
        addClick(chengyuan_Add_tv);
    }

    public void Init_Data() {
        setTitle(null);
        setNoFloatButtons(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
            case R.id.chengyuan_add_test_click:
//                Fragment_Center.loadchengyuanAdd();
                chengyuan_Add.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_chengyuan_Add:
//                Fragment_Center.loadchengyuanAdd();
                chengyuan_Add.setVisibility(View.GONE);
                break;
        }
    }

}
