package com.xcooper.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xcooper.Constant;
import com.xcooper.R;
import com.xcooper.adapter.MyViewPagerAdapter;
import com.xcooper.view.RevealLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hh on 2016.4.14.
 */
public class fanqiezhongFragment extends MyFragment {

    public static fanqiezhongFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getFanqiezhongFragment();
        setLAYOUT(R.layout.fanqiezhong);
    }


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    TextView text_fanqiezhong_click;

    public void Init_View(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.fanqiezhong_renwu, null);
        view2 = mInflater.inflate(R.layout.fanqiezhong_lishi, null);

        text_fanqiezhong_click = (TextView) view1.findViewById(R.id.text_fanqiezhong_click);

    }

    public void Init_Data() {

        setTitle("番茄钟");
        setFloatButtons(2, new int[]{R.drawable.open, R.drawable.kefu}, new String[]{
                "返回", "新增番茄钟"
        });

        mViewList = new ArrayList<>();//页卡视图集合
        mTitleList = new ArrayList<>();//页卡视图集合


        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);

        //添加页卡标题
        mTitleList.add("任务");
        mTitleList.add("历史");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(mViewList, mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    @Override
    public void Init_Listener() {
        addClick(text_fanqiezhong_click);
        getFloatButtons(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Center.loadfanqiezhongXiangqing(Fragment_Center.fanqiezhongFragment_num);
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
            case R.id.text_fanqiezhong_click:
                Fragment_Center.loadfanqiezhongXiangqing(Fragment_Center.fanqiezhongFragment_num);
                break;
        }
    }

}