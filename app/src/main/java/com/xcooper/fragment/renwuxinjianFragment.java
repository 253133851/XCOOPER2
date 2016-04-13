package com.xcooper.fragment;

import android.view.View;

import com.xcooper.R;

/**
 * Created by hh on 2016.4.12.
 */
public class renwuxinjianFragment extends MyFragment {


    public static renwuxinjianFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getRenwuxinjianFragment();
        setLAYOUT(R.layout.renwuxinjian);
        Fragment.setFROM((Integer) getArguments().get("from"));
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {
//        setTitle("新建任务");
        setTitle(null);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
        }
    }

}
