package com.xcooper.fragment;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.Bean.BEAN_INSTANSE;
import com.xcooper.Common.data.PostDataStringRequest;
import com.xcooper.Common.util.MD5;
import com.xcooper.Common.util.StrUtil;
import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;

import java.util.HashMap;
import java.util.Map;

public class chengyuanFragment extends MyFragment {

    public static chengyuanFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getChengyuanFragment();
        setLAYOUT(R.layout.chengyuan);
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {
        setTitle("成员");
    }

    public void Init_Listener() {
        setFloatButtons(3, new int[]{R.drawable.open, R.drawable.kefu, R.drawable.dingdan},
                new String[]{"返回", "新增成员", "管理成员"});
    }

    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

}
