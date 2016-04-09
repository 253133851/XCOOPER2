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
import com.xcooper.MyAsynctask;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;
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

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private ButtonFloat open, shuaxin, kefu;
    private TextView tips_open, tips_shuaxin, tips_kefu;
    private ImageView open_gray;


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    RevealLayout renwu_test_click;

    @Override
    public void Init_View(View view) {

        open = (ButtonFloat) view.findViewById(R.id.open);
//        dingdan = (ButtonFloat) view.findViewById(R.id.dingdan);
//        baoxiu = (ButtonFloat) view.findViewById(R.id.baoxiu);
        shuaxin = (ButtonFloat) view.findViewById(R.id.shuaxin);
        kefu = (ButtonFloat) view.findViewById(R.id.kefu);
        tips_open = (TextView) view.findViewById(R.id.tv_tips_open);
//        tips_dingdan = (TextView) view.findViewById(R.id.tv_tips_dingdan);
//        tips_baoxiu = (TextView) view.findViewById(R.id.tv_tips_baoxiu);
        tips_shuaxin = (TextView) view.findViewById(R.id.tv_tips_shuaxin);
        tips_kefu = (TextView) view.findViewById(R.id.tv_tips_kefu);
        open_gray = (ImageView) view.findViewById(R.id.open_gray);


        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.wofuzede, null);
        view2 = mInflater.inflate(R.layout.wofaqide, null);
        view3 = mInflater.inflate(R.layout.woguanzude, null);

        renwu_test_click = (RevealLayout) view1.findViewById(R.id.renwu_test_click);

    }

    SimpleAdapter adapter;
    List<Map<String, String>> list = new ArrayList<>();

    @Override
    public void Init_Data() {

        mainActivity.mToolbar.setVisibility(View.VISIBLE);
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

        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

        mainActivity.title.setText("任务");

    }

    @Override
    public void Init_Listener() {
        addClick(open);
        addClick(open_gray);
        addClick(shuaxin);
        addClick(renwu_test_click);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                float_button_click();
                break;
            case R.id.open_gray:
                float_button_click();
                break;
            case R.id.shuaxin:
                break;
            case R.id.renwu_test_click:
                Fragment_Center.loadRenwuXiangqing();
                break;

        }
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


    /**
     * 悬浮按钮点击事件
     */
    public void float_button_click() {
        set_anim();
    }


    public void set_anim() {
        Animation animation_open = AnimationUtils.loadAnimation(Constant.context, R.anim.open_anim);
        Animation animation_close = AnimationUtils.loadAnimation(Constant.context, R.anim.close_anim);
        Animation alphaAnimation = null;

        if (open.getTag().equals("close")) {
            alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
            open_gray.setVisibility(View.VISIBLE);
            alphaAnimation.setDuration(251);
            open_gray.setAnimation(alphaAnimation);
            alphaAnimation.startNow();
            open.startAnimation(animation_open);
            start_anim(tips_open, tips_open, 0);
            start_anim(kefu, tips_kefu, 0);
            start_anim(shuaxin, tips_shuaxin, 50);
//            start_anim(dingdan, tips_dingdan, 100);
//            start_anim(baoxiu, tips_baoxiu, 150);
        } else if (open.getTag().equals("open")) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(100);
            alphaAnimation.setStartOffset(250);//执行前的等待时间
            open_gray.setAnimation(alphaAnimation);
            alphaAnimation.startNow();
            open.startAnimation(animation_close);
            start_anim(tips_open, tips_open, 150);
            start_anim(kefu, tips_kefu, 150);
            start_anim(shuaxin, tips_shuaxin, 100);
//            start_anim(dingdan, tips_dingdan, 50);
//            start_anim(baoxiu, tips_baoxiu, 0);
        }

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (open.getTag().equals("close")) {
                    open.setTag("open");
                } else if (open.getTag().equals("open")) {
                    open.setTag("close");
                    open_gray.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    /**
     * floatbutton点击动画
     *
     * @param view
     * @param tips
     * @param startOffset
     */
    public void start_anim(View view, View tips, long startOffset) {
        Animation animation;
        if (open.getTag().equals("close")) {
            //初始化
            animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
            //设置动画时间
            view.setVisibility(View.VISIBLE);
            tips.setVisibility(View.VISIBLE);
        } else {
            //初始化
            animation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
            //设置动画时间
            view.setVisibility(View.GONE);
            tips.setVisibility(View.GONE);
        }
        animation.setDuration(100);
        view.setAnimation(animation);
        tips.setAnimation(animation);
        animation.setStartOffset(startOffset);//执行前的等待时间
        animation.startNow();

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
