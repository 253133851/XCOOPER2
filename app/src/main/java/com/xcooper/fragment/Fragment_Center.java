package com.xcooper.fragment;

/**
 * 界面标识中心 用于给不同的页面分配不同的标识
 */
public class Fragment_Center {

    public static int LoginFragment_num = 0;      //登录页面
    public static int mainFragment_num = 1;       //主页面
    public static int chengyuanFragment_num = 2;       //主页面
    public static int tongzhiFragment_num = 3;       //主页面
    public static int xiangmuFragment_num = 4;       //主页面

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
        return (xiangmuFragment) xiangmuFragment.getInstance(xiangmuFragment.class, tongzhiFragment.Fragment);
    }

}
