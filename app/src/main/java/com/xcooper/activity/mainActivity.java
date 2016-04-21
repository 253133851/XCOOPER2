package com.xcooper.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.gc.materialdesign.widgets.Dialog;
import com.xcooper.Bean.BEAN_INSTANSE;
import com.xcooper.Constant;
import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.fragment.Fragment_Center;
import com.xcooper.fragment.chengyuanFragment;
import com.xcooper.fragment.loginFragment;
import com.xcooper.fragment.mainFragment;
import com.xcooper.fragment.tongzhiFragment;
import com.xcooper.view.RevealLayout;

import java.util.ArrayList;
import java.util.List;

public class mainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Constant.context = getBaseContext();
        Constant.activity = this;

        initViews();
        initDatas();
        initListeners();
    }


    public static DrawerLayout mDrawerLayout;
    public static ActionBarDrawerToggle mDrawerToggle;
    public static Toolbar mToolbar;
    public static TextView title;
    private RevealLayout ll_chengyuan, ll_tongzhi, ll_renwu, ll_xiangmu, ll_dongtai, ll_fanqiezhong, ll_zhuxiao;

    /**
     * 初始化数据
     */
    public void initDatas() {

        BEAN_INSTANSE.initBean(this);

        Constant.activity.setSupportActionBar(mToolbar);
        Constant.activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        Constant.activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Constant.activity.getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用

        Fragment_Center.loadRenWu();
    }

    public static ButtonFloat view0, view1, view2, view3, view4;
    public static TextView tv_tips_view0, tv_tips_view1, tv_tips_view2, tv_tips_view3, tv_tips_view4;
    public static List<ButtonFloat> ButtonFloatList = new ArrayList<>();
    public static List<TextView> ButtonFloatTipsList = new ArrayList<>();
    public static ImageView open_gray;
    public static int ButtonFloatLength = 5;

    /**
     * 初始化组件
     */
    public void initViews() {
        ll_chengyuan = (RevealLayout) findViewById(R.id.ll_chengyuan);
        ll_tongzhi = (RevealLayout) findViewById(R.id.ll_tongzhi);
        ll_renwu = (RevealLayout) findViewById(R.id.ll_renwu);
        ll_xiangmu = (RevealLayout) findViewById(R.id.ll_xiangmu);
        ll_dongtai = (RevealLayout) findViewById(R.id.ll_dongtai);
        ll_zhuxiao = (RevealLayout) findViewById(R.id.ll_zhuxiao);
        ll_fanqiezhong = (RevealLayout) findViewById(R.id.ll_fanqiezhong);

        title = (TextView) findViewById(R.id.title);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(Constant.activity, mDrawerLayout, mToolbar, 0, 0);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //全局的悬浮按钮 最多5个
        view0 = (ButtonFloat) findViewById(R.id.view0);
        view1 = (ButtonFloat) findViewById(R.id.view1);
        view2 = (ButtonFloat) findViewById(R.id.view2);
        view3 = (ButtonFloat) findViewById(R.id.view3);
        view4 = (ButtonFloat) findViewById(R.id.view4);
        tv_tips_view0 = (TextView) findViewById(R.id.tv_tips_view0);
        tv_tips_view1 = (TextView) findViewById(R.id.tv_tips_view1);
        tv_tips_view2 = (TextView) findViewById(R.id.tv_tips_view2);
        tv_tips_view3 = (TextView) findViewById(R.id.tv_tips_view3);
        tv_tips_view4 = (TextView) findViewById(R.id.tv_tips_view4);
        open_gray = (ImageView) findViewById(R.id.open_gray);
        ButtonFloatList.add(0, view0);
        ButtonFloatList.add(1, view1);
        ButtonFloatList.add(2, view2);
        ButtonFloatList.add(3, view3);
        ButtonFloatList.add(4, view4);
        ButtonFloatTipsList.add(0, tv_tips_view0);
        ButtonFloatTipsList.add(1, tv_tips_view1);
        ButtonFloatTipsList.add(2, tv_tips_view2);
        ButtonFloatTipsList.add(3, tv_tips_view3);
        ButtonFloatTipsList.add(4, tv_tips_view4);
    }

    /**
     * 初始化监听器
     */
    private void initListeners() {
        view0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_anim();
            }
        });

        open_gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_anim();
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    mDrawerLayout.closeDrawers();
                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });

        ll_chengyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadChengyuan();
            }
        });

        ll_tongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadTongZhi();
            }
        });

        ll_renwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadRenWu();
            }
        });

        ll_xiangmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadXiangmu();
            }
        });

        ll_dongtai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadDongtai();
            }
        });

        ll_zhuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadZhuxiao();
            }
        });

        ll_fanqiezhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Fragment_Center.loadfanqiezhong();
            }
        });

    }

    public static void setFloatButtons(int length, int[] pics, String[] tips) {

        for (int i = 1; i < 5; i++) {
            ButtonFloatList.get(i).setOnClickListener(null);
        }
        if (view0.getTag().equals("open")) {
            set_anim();
        }
        ButtonFloatLength = length;
        if (length >= 1) {
            view0.setVisibility(View.VISIBLE);
//            if (!view0.isShow()) {
//                view0.show();
//            }
        } else {
            view0.setVisibility(View.GONE);
//            if (view0.isShow()) {
//                view0.hide();
//            }
        }
        for (int i = 0; i < ButtonFloatLength; i++) {
            if (pics.length >= length && tips.length >= length) {
                ButtonFloatList.get(i).setDrawableIcon(Constant.activity.getResources().getDrawable(pics[i]));
                ButtonFloatTipsList.get(i).setText(tips[i]);
            }
        }
    }

    public static ButtonFloat getFloatButtons(int i) {
        return ButtonFloatList.get(i - 1);
    }

    public static void set_anim() {
        Animation animation_open = AnimationUtils.loadAnimation(Constant.context, R.anim.open_anim);
        Animation animation_close = AnimationUtils.loadAnimation(Constant.context, R.anim.close_anim);
        Animation alphaAnimation = null;

        if (view0.getTag().equals("close")) {
            alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
            open_gray.setVisibility(View.VISIBLE);
            alphaAnimation.setDuration(251);
            open_gray.setAnimation(alphaAnimation);
            alphaAnimation.startNow();
            view0.startAnimation(animation_open);
            start_anim(tv_tips_view0, tv_tips_view0, 0);
            if (ButtonFloatLength >= 2)
                start_anim(view1, tv_tips_view1, 0);
            if (ButtonFloatLength >= 3)
                start_anim(view2, tv_tips_view2, 50);
            if (ButtonFloatLength >= 4)
                start_anim(view3, tv_tips_view3, 100);
            if (ButtonFloatLength >= 5)
                start_anim(view4, tv_tips_view4, 150);
        } else if (view0.getTag().equals("open")) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(100);
            alphaAnimation.setStartOffset(250);
            open_gray.setAnimation(alphaAnimation);
            alphaAnimation.startNow();
            view0.startAnimation(animation_close);
            start_anim(tv_tips_view0, tv_tips_view0, 150);
            if (ButtonFloatLength >= 2)
                start_anim(view1, tv_tips_view1, 150);
            if (ButtonFloatLength >= 3)
                start_anim(view2, tv_tips_view2, 100);
            if (ButtonFloatLength >= 4)
                start_anim(view3, tv_tips_view3, 50);
            if (ButtonFloatLength >= 5)
                start_anim(view4, tv_tips_view4, 0);
        }

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (view0.getTag().equals("close")) {
                    view0.setTag("open");
                } else if (view0.getTag().equals("open")) {
                    view0.setTag("close");
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
     */
    public static void start_anim(View view, View tips, long startOffset) {
        Animation animation;
        if (view0.getTag().equals("close")) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        System.out.println("当前 " + Constant.Reccent_Frag);
        if (Constant.Reccent_Frag == Fragment_Center.chengyuanFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.tongzhiFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.dongtaiFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.xiangmuFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.fanqiezhongFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.renwuxiangqingFragment_num) {
            Fragment_Center.loadRenWu();
        } else if (Constant.Reccent_Frag == Fragment_Center.xiangmuAddFragment_num) {
            getFragmentManager().popBackStack();
            Constant.Reccent_Frag = Fragment_Center.xiangmuFragment_num;
        } else if (Constant.Reccent_Frag == Fragment_Center.xiangmuMainFragment_num) {
            getFragmentManager().popBackStack();
            Constant.Reccent_Frag = Fragment_Center.xiangmuFragment_num;
        } else if (Constant.Reccent_Frag == Fragment_Center.chengyuanAddFragment_num) {
            getFragmentManager().popBackStack();
            Constant.Reccent_Frag = Fragment_Center.xiangmuAddFragment_num;
        } else if (Constant.Reccent_Frag == Fragment_Center.fanqiezhongXiangqingFragment_num) {
            System.out.println(Fragment_Center.getFanqiezhongXiangqingFragment().getFROM());
            if (Fragment_Center.getFanqiezhongXiangqingFragment().getFROM() == Fragment_Center.mainFragment_num) {
                Fragment_Center.loadRenWu();
            } else if (Fragment_Center.getFanqiezhongXiangqingFragment().getFROM() == Fragment_Center.fanqiezhongFragment_num) {
                getFragmentManager().popBackStack();
                Constant.Reccent_Frag = Fragment_Center.fanqiezhongFragment_num;
            }
        } else if (Constant.Reccent_Frag == Fragment_Center.renwuxinjianFragment_num) {
            if (Fragment_Center.getRenwuxinjianFragment().getFROM() == Fragment_Center.mainFragment_num) {
                Fragment_Center.loadRenWu();
            } else {
                getFragmentManager().popBackStack();
                Constant.Reccent_Frag = Fragment_Center.xiangmuMainFragment_num;
            }
        } else {
            Method_Center.show_Toast("Out", true);
            super.onBackPressed();
        }
    }

}
