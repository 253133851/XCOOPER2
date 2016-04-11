package com.xcooper.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

//ViewPager  ≈‰∆˜
public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> mViewList;
    private List<String> mTitleList;

    public MyViewPagerAdapter(List<View> mViewList, List<String> mTitleList) {
        this.mViewList = mViewList;
        this.mTitleList = mTitleList;
    }

    @Override
    public int getCount() {
        return mViewList.size();//“≥ø® ˝
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//πŸ∑ΩÕ∆ºˆ–¥∑®
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));//ÃÌº”“≥ø®
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));//…æ≥˝“≥ø®
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);//“≥ø®±ÍÃ‚
    }

}