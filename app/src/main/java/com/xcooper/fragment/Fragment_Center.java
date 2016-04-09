package com.xcooper.fragment;

import android.app.FragmentManager;

import com.xcooper.Constant;
import com.xcooper.Method_Center;

/**
 * 界面标识中心 用于给不同的页面分配不同的标识
 */
public class Fragment_Center {

    public static int LoginFragment_num = 0;      //登录页面
    public static int mainFragment_num = 1;       //主页面
    public static int chengyuanFragment_num = 2;       //主页面
    public static int tongzhiFragment_num = 3;       //主页面
    public static int xiangmuFragment_num = 4;       //主页面
    public static int dongtaiFragment_num = 5;       //主页面
    public static int renwuxiangqingFragment_num = 6;       //主页面
    public static int xiangmuAddFragment_num = 7;       //主页面
    public static int xiangmuMainFragment_num = 8;
    public static int chengyuanAddFragment_num = 9;

    //成员界面
    public static void loadChengyuan() {
        Constant.Reccent_Frag = Fragment_Center.chengyuanFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getChengyuanFragment(), "chengyuan", null);
    }

    public static void loadTongZhi() {
        Constant.Reccent_Frag = Fragment_Center.tongzhiFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getTongzhiFragment(), "tongzhi", null);

    }

    public static void loadXiangmu() {
        Constant.Reccent_Frag = Fragment_Center.xiangmuFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getXiangmuFragment(), "xiangmu", null);
    }

    public static void loadRenWu() {
        Constant.activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Constant.Reccent_Frag = Fragment_Center.mainFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getMainFragment(), "main", null);
    }

    public static void loadDongtai() {
        Constant.Reccent_Frag = Fragment_Center.dongtaiFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getDongtaiFragment(), "dongtai", null);
    }

    public static void loadZhuxiao() {
        Constant.activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Constant.Reccent_Frag = Fragment_Center.LoginFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getLoginFragment(), "login", null);
    }

    public static void loadRenwuXiangqing() {
        Constant.Reccent_Frag = Fragment_Center.renwuxiangqingFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getRenwuxiangqingFragment(), "renwuxiangqing", null);
    }

    public static void loadxiangmuAdd() {
        Constant.Reccent_Frag = Fragment_Center.xiangmuAddFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getxiangmuAddFragment(), "xiangmuAdd", null);
    }

    public static void loadxiangmuMain() {
        Constant.Reccent_Frag = Fragment_Center.xiangmuMainFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getxiangmuMainFragment(), "xiangmuxiangxi", null);
    }

    public static void loadchengyuanAdd() {
        Constant.Reccent_Frag = Fragment_Center.chengyuanAddFragment_num;
        Method_Center.turnToFragment(Constant.activity.getFragmentManager(), Fragment_Center.getChengyuanAddFragment(), "chengyuanAdd", null);
    }

    //每一个界面 获取实例对象的方法
    public static loginFragment getLoginFragment() {
        return (loginFragment) loginFragment.getInstance(loginFragment.class, loginFragment.Fragment);
    }

    public static mainFragment getMainFragment() {
        return (mainFragment) mainFragment.getInstance(mainFragment.class, mainFragment.Fragment);
    }

    public static chengyuanFragment getChengyuanFragment() {
        return (chengyuanFragment) chengyuanFragment.getInstance(chengyuanFragment.class, chengyuanFragment.Fragment);
    }

    public static tongzhiFragment getTongzhiFragment() {
        return (tongzhiFragment) tongzhiFragment.getInstance(tongzhiFragment.class, tongzhiFragment.Fragment);
    }

    public static xiangmuFragment getXiangmuFragment() {
        return (xiangmuFragment) xiangmuFragment.getInstance(xiangmuFragment.class, xiangmuFragment.Fragment);
    }

    public static dongtaiFragment getDongtaiFragment() {
        return (dongtaiFragment) dongtaiFragment.getInstance(dongtaiFragment.class, dongtaiFragment.Fragment);
    }

    public static renwuxiangqingFragment getRenwuxiangqingFragment() {
        return (renwuxiangqingFragment) renwuxiangqingFragment.getInstance(renwuxiangqingFragment.class, renwuxiangqingFragment.Fragment);
    }

    public static xiangmuAddFragment getxiangmuAddFragment() {
        return (xiangmuAddFragment) xiangmuAddFragment.getInstance(xiangmuAddFragment.class, xiangmuAddFragment.Fragment);
    }

    public static xiangmuMainFragment getxiangmuMainFragment() {
        return (xiangmuMainFragment) xiangmuMainFragment.getInstance(xiangmuMainFragment.class, xiangmuMainFragment.Fragment);
    }

    public static chengyuanAddFragment getChengyuanAddFragment() {
        return (chengyuanAddFragment) chengyuanAddFragment.getInstance(chengyuanAddFragment.class, chengyuanAddFragment.Fragment);
    }
}
