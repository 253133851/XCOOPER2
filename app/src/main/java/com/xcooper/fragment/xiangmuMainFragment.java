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
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.Constant;
import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hh on 2016.4.9.
 */
public class xiangmuMainFragment extends MyFragment {


    public static xiangmuMainFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getxiangmuMainFragment();
        setLAYOUT(R.layout.xiangmuxiangxi);
    }

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

        setTitle("项目");
        setNoFloatButtons(true);

        mViewList = new ArrayList<>();//页卡视图集合
        mTitleList = new ArrayList<>();//页卡视图集合

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.xiangmu_renwu, null);
        view2 = mInflater.inflate(R.layout.xiangmu_taolun, null);
        view3 = mInflater.inflate(R.layout.xiangmu_wendang, null);

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //添加页卡标题
        mTitleList.add("任务");
        mTitleList.add("未读");
        mTitleList.add("文档");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    public void Init_Listener() {

    }

    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }

    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

}