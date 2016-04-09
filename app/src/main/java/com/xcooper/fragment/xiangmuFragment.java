package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;

/**
 * Created by 26901 on 2016.4.9.
 */
public class xiangmuFragment extends MyFragment {

    public static xiangmuFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getXiangmuFragment();
        setLAYOUT(R.layout.xiangmu);
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}
