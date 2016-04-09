package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;
import com.xcooper.activity.mainActivity;

/**
 * Created by hh on 2016.4.9.
 */
public class dongtaiFragment extends MyFragment {


    public static dongtaiFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getDongtaiFragment();
        setLAYOUT(R.layout.dongtai);
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {

        mainActivity.title.setText("动态");

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}
