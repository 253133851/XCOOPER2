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
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.Constant;
import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;
import com.xcooper.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class tongzhiFragment extends MyFragment {

    public static tongzhiFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getTongzhiFragment();
        setLAYOUT(R.layout.tongzhi);
    }

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    public void Init_View(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
    }

    public void Init_Data() {

        setTitle("任务通知");
        setNoFloatButtons(true);

        mViewList = new ArrayList<>();//页卡视图集合
        mTitleList = new ArrayList<>();//页卡视图集合

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.weidutongzhi, null);
        view2 = mInflater.inflate(R.layout.weidutongzhi, null);

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);

        //添加页卡标题
        mTitleList.add("未读通知");
        mTitleList.add("全部通知");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(mViewList, mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    public void Init_Listener(){
    }


    public void onClick(View view) {
        switch (view.getId()) {

        }
    }


}
