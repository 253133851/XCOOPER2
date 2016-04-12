package com.xcooper.fragment;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.Bean.BEAN_INSTANSE;
import com.xcooper.Common.data.PostDataStringRequest;
import com.xcooper.Common.util.MD5;
import com.xcooper.Common.util.StrUtil;
import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;

import java.util.HashMap;
import java.util.Map;

public class chengyuanFragment extends MyFragment {

    public static chengyuanFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getChengyuanFragment();
        setLAYOUT(R.layout.chengyuan);
    }

    private ButtonFloat open, shuaxin, kefu;
    private TextView tips_open, tips_shuaxin, tips_kefu;
    private ImageView open_gray;


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
    }

    public void Init_Data() {
        setTitle("成员");
    }

    public void Init_Listener() {
        addClick(open);
        addClick(open_gray);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open:
                float_button_click();
                break;
            case R.id.open_gray:
                float_button_click();
                break;
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
            start_anim((String) open.getTag(), tips_open, tips_open, 0);
            start_anim((String) open.getTag(), kefu, tips_kefu, 0);
            start_anim((String) open.getTag(), shuaxin, tips_shuaxin, 50);
//            start_anim(dingdan, tips_dingdan, 100);
//            start_anim(baoxiu, tips_baoxiu, 150);
        } else if (open.getTag().equals("open")) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(100);
            alphaAnimation.setStartOffset(250);//执行前的等待时间
            open_gray.setAnimation(alphaAnimation);
            alphaAnimation.startNow();
            open.startAnimation(animation_close);
            start_anim((String) open.getTag(), tips_open, tips_open, 150);
            start_anim((String) open.getTag(), kefu, tips_kefu, 150);
            start_anim((String) open.getTag(), shuaxin, tips_shuaxin, 100);
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
    public void start_anim(String tag, View view, View tips, long startOffset) {
        Animation animation;
        if (tag.equals("close")) {
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

}
