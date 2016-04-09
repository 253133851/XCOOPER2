package com.xcooper;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.xcooper.fragment.MyFragment;

public class Method_Center {

    /**
     * 显示提示
     */
    public static void show_Toast(String message, boolean if_short) {
        Snackbar.SnackbarDuration during = Snackbar.SnackbarDuration.LENGTH_SHORT;
        if (if_short == false) {
            during = Snackbar.SnackbarDuration.LENGTH_LONG;
        }
        Snackbar.with(Constant.context) // context
                .text(message) // text to display
                .actionLabel("OK") // action button label
                .actionListener(new ActionClickListener() {
                    @Override
                    public void onActionClicked(Snackbar snackbar) {

                    }
                }) // action button's ActionClickListener
                .duration(during) // make it shorter
                .show(Constant.activity); // activity where it is displayed
    }

    /**
     * 多种隐藏键盘方法的其中一种
     */
    public static void hideSoftInput() {
        ((InputMethodManager) Constant.context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(Constant.activity.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    /**
     * Fragment跳转
     *
     * @param fm
     * @param tag
     * @param args
     */
    public static void turnToFragment(FragmentManager fm, MyFragment
            frag, String tag, Bundle args) {
        Fragment fragment = fm.findFragmentByTag(tag);
        boolean isFragmentExist = true;
        if (fragment == null) {
//            try {
            isFragmentExist = false;
//                fragment = (MyFragment) fragmentClass.newInstance();
            fragment = frag;
            fragment.setArguments(new Bundle());
//            } catch (java.lang.InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
        }
        if (fragment.isAdded()) {
            return;
        }
        if (args != null && !args.isEmpty()) {
            fragment.getArguments().putAll(args);
        }
        FragmentTransaction ft = fm.beginTransaction();
//        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
//                android.R.anim.fade_in, android.R.anim.fade_out);
        if (isFragmentExist) {
            ft.replace(Constant.main_frame, fragment);
        } else {
            ft.replace(Constant.main_frame, fragment, tag);
        }
        ft.addToBackStack(tag);
        ft.commitAllowingStateLoss();
    }

}

