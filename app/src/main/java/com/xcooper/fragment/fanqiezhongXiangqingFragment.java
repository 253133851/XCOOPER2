package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;

/**
 * Created by hh on 2016.4.14.
 */
public class fanqiezhongXiangqingFragment extends MyFragment {

    public static fanqiezhongXiangqingFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getFanqiezhongXiangqingFragment();
        setLAYOUT(R.layout.fanqiezhong_xiangqing);
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {
        setTitle("¶¯Ì¬");

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}