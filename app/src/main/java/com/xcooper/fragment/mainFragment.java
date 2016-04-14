package com.xcooper.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.MyAsynctask;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;
import com.xcooper.adapter.MyViewPagerAdapter;
import com.xcooper.view.RevealLayout;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页
 */
public class mainFragment extends MyFragment {

    public static mainFragment Fragment;

    @Override
    public void Pre() {
        super.Pre();
        if (Fragment == null) Fragment = Fragment_Center.getMainFragment();
        setLAYOUT(R.layout.activity_main);
    }

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    RevealLayout renwu_test_click;

    @Override
    public void Init_View(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.wofuzede, null);
        view2 = mInflater.inflate(R.layout.wofaqide, null);
        view3 = mInflater.inflate(R.layout.woguanzude, null);

        renwu_test_click = (RevealLayout) view1.findViewById(R.id.renwu_test_click);

        mainActivity.setFloatButtons(3, new int[]{
                R.drawable.open,
                R.drawable.shuaxin,
                R.drawable.baoxiu,
        }, new String[]{
                "返回", "新建任务", "番茄钟"
        });
    }

    SimpleAdapter adapter;
    List<Map<String, String>> list = new ArrayList<>();

    @Override
    public void Init_Data() {

        setTitle("任务");
        mainActivity.mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        mViewList = new ArrayList<>();//页卡视图集合
        mTitleList = new ArrayList<>();//页卡视图集合

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //添加页卡标题
        mTitleList.add("我负责的");
        mTitleList.add("我发起的");
        mTitleList.add("我关注的");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(mViewList, mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

    }

    @Override
    public void Init_Listener() {
        addClick(renwu_test_click);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.renwu_test_click:
                Fragment_Center.loadRenwuXiangqing();
                break;
        }
    }

    public void load_Data() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("time", "2016-01-06");
        map.put("confirm", "-1");
        map.put("done", "-1");
        new MyAsynctask(map, ENV.URL_GET_ORDER_LIST) {
            public void OK(JSONObject code) {

                JSONObject json = code.getJSONObject("data");
                JSONArray order_listArray = json.getJSONArray("order_list");
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
