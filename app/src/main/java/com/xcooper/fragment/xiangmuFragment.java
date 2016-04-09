package com.xcooper.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;

/**
 * Created by 26901 on 2016.4.9.
 */
public class xiangmuFragment extends MyFragment {

    public static xiangmuFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getXiangmuFragment();
        setLAYOUT(R.layout.xiangmu);
    }

    ButtonFloat but_new_xiangmu;
    LinearLayout xiangmu_test_click;


    public void Init_View(View view) {
        but_new_xiangmu = (ButtonFloat) view.findViewById(R.id.but_new_xiangmu);
        xiangmu_test_click = (LinearLayout) view.findViewById(R.id.xiangmu_test_click);
    }

    public void Init_Data() {
        mainActivity.title.setText("项目列表");
    }

    public void Init_Listener() {
        addClick(but_new_xiangmu);
        addClick(xiangmu_test_click);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_new_xiangmu:
                Fragment_Center.loadxiangmuAdd();
                break;
            case R.id.xiangmu_test_click:
                Fragment_Center.loadxiangmuMain();
                break;
        }
    }

}
