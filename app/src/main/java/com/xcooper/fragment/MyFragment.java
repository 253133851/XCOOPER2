package com.xcooper.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.xcooper.Method_Center;

/**
 * 重写的Fragment类  自定义需要的内容
 */
public class MyFragment extends Fragment implements Fragment_Pre, Init, View.OnClickListener {

    int LAYOUT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Pre();
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, null);
        Init_View(view);
        Init_Data();
        Init_Listener();
        return view;
    }

    //防止fragment之间出现触摸事件穿透的情况 将触摸事件截取在这一层
    public void onStart() {
        getView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        super.onStart();
    }

    //为每一个Fragment分配唯一的一个实例
    public static synchronized Object getInstance(Class frag_class, Object fragment_child) {
        if (fragment_child == null) {
            synchronized (frag_class) {
                if (fragment_child == null) {
                    try {
                        fragment_child = frag_class.newInstance(); //新建实例
                        //    setFRAG(fragment_child); //赋值
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fragment_child;
    }

    public void Pre() {
    }

    public void Init_View(View view) {

    }

    public void Init_Data() {

    }

    public void Init_Listener() {

    }

    public void addClick(View view) {
        view.setOnClickListener(this);
    }


    public int getLAYOUT() {
        return LAYOUT;
    }

    public void setLAYOUT(int LAYOUT) {
        this.LAYOUT = LAYOUT;
    }

    public void onClick(View view) {

    }

    public void setTitle(String name) {
        Method_Center.setToolBarName(name);
    }

}

/**
 * 用于在create_View之前的操作接口 现在用来给子类实例赋值
 */
interface Fragment_Pre {

    void Pre();

}

/**
 * 用于规范化Fragment的代码
 */
interface Init {

    void Init_View(View view);

    void Init_Data();

    void Init_Listener();

}
