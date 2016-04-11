package com.xcooper.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.xcooper.Method_Center;

/**
 * ��д��Fragment��  �Զ�����Ҫ������
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

    //��ֹfragment֮����ִ����¼���͸����� �������¼���ȡ����һ��
    public void onStart() {
        getView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        super.onStart();
    }

    //Ϊÿһ��Fragment����Ψһ��һ��ʵ��
    public static synchronized Object getInstance(Class frag_class, Object fragment_child) {
        if (fragment_child == null) {
            synchronized (frag_class) {
                if (fragment_child == null) {
                    try {
                        fragment_child = frag_class.newInstance(); //�½�ʵ��
                        //    setFRAG(fragment_child); //��ֵ
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
 * ������create_View֮ǰ�Ĳ����ӿ� ��������������ʵ����ֵ
 */
interface Fragment_Pre {

    void Pre();

}

/**
 * ���ڹ淶��Fragment�Ĵ���
 */
interface Init {

    void Init_View(View view);

    void Init_Data();

    void Init_Listener();

}
