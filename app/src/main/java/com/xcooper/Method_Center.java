package com.xcooper;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.xcooper.activity.mainActivity;
import com.xcooper.fragment.MyFragment;

import java.util.Calendar;

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
            frag, String tag, Bundle args, int from) {
        MyFragment fragment = (MyFragment) fm.findFragmentByTag(tag);
        boolean isFragmentExist = true;
        if (fragment == null) {
            isFragmentExist = false;
            fragment = frag;
            Bundle bundle = new Bundle();
            bundle.putInt("from", from);
            fragment.setArguments(bundle);
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

    /**
     * 设置toolbar名称
     * null则隐藏toolbar
     *
     * @param name
     */
    public static void setToolBarName(String name) {
        if (null != name && !("").equals(name)) {
            mainActivity.mToolbar.setVisibility(View.VISIBLE);
            mainActivity.title.setText(name);
        } else {
            mainActivity.mToolbar.setVisibility(View.GONE);
        }
    }

    public static String datePick = "";

    public static void DatePicker(String title) {

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog datePickerDialog, int year, int monthOfYear, int dayOfMonth) {
                        datePick = +dayOfMonth + "-" + (++monthOfYear) + "-" + year;
                    }
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setThemeDark(true);

        dpd.setTitle(title);

        dpd.show(Constant.activity.getFragmentManager(), "Datepickerdialog");
    }

}

