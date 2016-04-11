package com.xcooper.fragment;

import android.view.View;

import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;

/**
 * Created by hh on 2016.4.9.
 */
public class renwuxiangqingFragment extends MyFragment {

    public static renwuxiangqingFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getRenwuxiangqingFragment();
        setLAYOUT(R.layout.renwuxiangqing);
    }

    public void Init_View(View view) {
        setTitle(null);
    }

    public void Init_Data() {
        mainActivity.mToolbar.setVisibility(View.GONE);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}