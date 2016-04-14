package com.xcooper.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

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
    private List<String> mTitleList = new ArrayList<>();//ҳ�����⼯��
    private View view1, view2, view3, view4, view5;//ҳ����ͼ
    private List<View> mViewList = new ArrayList<>();//ҳ����ͼ����

    RevealLayout text_fanqiezhong_click;

    public void Init_View(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.fanqiezhong_renwu, null);
        view2 = mInflater.inflate(R.layout.fanqiezhong_lishi, null);

        text_fanqiezhong_click = (RevealLayout) view1.findViewById(R.id.text_fanqiezhong_click);

    }

    public void Init_Data() {

        setTitle("������");


        mViewList = new ArrayList<>();//ҳ����ͼ����
        mTitleList = new ArrayList<>();//ҳ����ͼ����


        //���ҳ����ͼ
        mViewList.add(view1);
        mViewList.add(view2);

        //���ҳ������
        mTitleList.add("����");
        mTitleList.add("��ʷ");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//����tabģʽ����ǰΪϵͳĬ��ģʽ
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//���tabѡ�
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(mViewList, mTitleList);
        mViewPager.setAdapter(mAdapter);//��ViewPager����������
        mTabLayout.setupWithViewPager(mViewPager);//��TabLayout��ViewPager����������
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//��Tabs����������
    }

    @Override
    public void Init_Listener() {
        addClick(text_fanqiezhong_click);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                break;
            case R.id.text_fanqiezhong_click:
                Fragment_Center.loadfanqiezhongXiangqing();
                break;
        }
    }

}