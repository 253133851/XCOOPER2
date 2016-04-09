package com.xcooper.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private RevealLayout ll_chengyuan, ll_tongzhi, ll_renwu, ll_xiangmu, ll_dongtai, ll_zhuxiao;

    /**
     * 初始化数据
     */
    public void initDatas() {
        BEAN_INSTANSE.initBean(this);

        Constant.activity.setSupportActionBar(mToolbar);
        Constant.activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        Constant.activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment_Center.loadRenWu();
    }

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

        title = (TextView) findViewById(R.id.title);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(Constant.activity, mDrawerLayout, mToolbar, 0, 0);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    /**
     * 初始化监听器
     */
    private void initListeners() {

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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onBackPressed() {


        if (Constant.Reccent_Frag == Fragment_Center.chengyuanFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.tongzhiFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.dongtaiFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.xiangmuFragment_num ||
                Constant.Reccent_Frag == Fragment_Center.renwuxiangqingFragment_num) {
//            getFragmentManager().popBackStack();
//            Constant.Reccent_Frag = Fragment_Center.mainFragment_num;
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
        } else {
            Method_Center.show_Toast("Out", true);
            super.onBackPressed();
        }
    }

}
