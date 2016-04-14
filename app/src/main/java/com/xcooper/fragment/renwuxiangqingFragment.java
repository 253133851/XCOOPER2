package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;
import com.xcooper.activity.mainActivity;
import com.xcooper.view.RoundProgressBar;

/**
 * Created by hh on 2016.4.9.
 */
public class renwuxiangqingFragment extends MyFragment {

    public static renwuxiangqingFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getRenwuxiangqingFragment();
        setLAYOUT(R.layout.renwuxiangqing);
    }

    RoundProgressBar progress;

    public void Init_View(View view) {
        progress = (RoundProgressBar) view.findViewById(R.id.roundProgressBar2);
    }

    public void Init_Data() {
        setTitle(null);
        setNoFloatButtons(true);
        progress.setText(6000);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}