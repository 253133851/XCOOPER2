package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;
import com.xcooper.activity.mainActivity;

/**
 * Created by hh on 2016.4.9.
 */
public class chengyuanAddFragment  extends MyFragment {


    public static chengyuanAddFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getChengyuanAddFragment();
        setLAYOUT(R.layout.chengyuan_add);
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {

        mainActivity.title.setText("添加成员");

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}
