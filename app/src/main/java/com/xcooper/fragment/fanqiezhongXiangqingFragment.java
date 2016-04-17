package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;
import com.xcooper.view.RoundProgressBar;

/**
 * Created by hh on 2016.4.14.
 */
public class fanqiezhongXiangqingFragment extends MyFragment {

    public static fanqiezhongXiangqingFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getFanqiezhongXiangqingFragment();
        setLAYOUT(R.layout.fanqiezhong_xiangqing);
        Fragment.setFROM((Integer) getArguments().get("from"));
        System.out.println("from "+Fragment.getFROM());
    }

    RoundProgressBar progress;

    public void Init_View(View view) {

        progress = (RoundProgressBar) view.findViewById(R.id.roundProgressBar2);
    }

    public void Init_Data() {
        setTitle("番茄钟 - 任务订单完成");
        setNoFloatButtons(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}