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
import android.widget.GridView;
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
import com.xcooper.adapter.XiangmuChengyuanAdapter;
import com.xcooper.vo.MemberVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chengyuanFragment extends MyFragment {

    public static chengyuanFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getChengyuanFragment();
        setLAYOUT(R.layout.chengyuan);
    }

    RelativeLayout chengyuan_Add;
    TextView chengyuan_Add_tv;
    GridView gv_chengyuan;

    public void Init_View(View view) {
        chengyuan_Add = (RelativeLayout) view.findViewById(R.id.rl_chengyuanAdd);
        chengyuan_Add_tv = (TextView) view.findViewById(R.id.tv_chengyuan_Add);
        gv_chengyuan = (GridView) view.findViewById(R.id.gv_chengyuan);
    }

    public void Init_Data() {

        setTitle("成员中心");

        List<MemberVO> memberList = BEAN_INSTANSE.memberBean.query();
        List<Map<String, String>> chengyuanList = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", memberList.get(i).getName());
            chengyuanList.add(map);
        }

        gv_chengyuan.setAdapter(new XiangmuChengyuanAdapter(chengyuanList, Constant.activity));
    }

    public void Init_Listener() {

        addClick(chengyuan_Add_tv);

        setFloatButtons(3, new int[]{R.drawable.open, R.drawable.kefu, R.drawable.dingdan},
                new String[]{"返回", "新增成员", "管理成员"});
        getFloatButtons(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chengyuan_Add.setVisibility(View.VISIBLE);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_chengyuan_Add:
                chengyuan_Add.setVisibility(View.GONE);
                break;
        }
    }

}
