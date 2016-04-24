package com.xcooper;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;

import com.xcooper.vo.MemberVO;
import com.xcooper.vo.ProjectVO;

import java.util.HashMap;
import java.util.Map;


public class Constant {

    public static Context context;

    public static ActionBarActivity activity;

    public static int Reccent_Frag = -1;       // 当前的界面 默认-1

    public static int main_frame = R.id.fl_main;

    public static Map<Integer, ProjectVO> projectMap = new HashMap<>();

    public static Map<Integer, MemberVO> memberMap = new HashMap<>();

}
