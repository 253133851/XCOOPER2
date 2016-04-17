package com.xcooper.Bean;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.sql.SQLException;

public class BEAN_INSTANSE {

    public static RequestQueue requestQueue;
    public static UserBean userBean;
    public static CommentBean commentBean;
    public static FileBean fileBean;
    public static ListBean listBean;
    public static LogBean logBean;
    public static LogTypeBean logTypeBean;
    public static MemberBean memberBean;
    public static MemberTaskBean memberTaskBean;
    public static ProjectBean projectBean;
    public static ProjectMemberBean projectMemberBean;
    public static ServiceBean serviceBean;
    public static ServiceUserMapBean serviceUserMapBean;
    public static TaskBean taskBean;
    public static TaskCheckItemBean taskCheckItemBean;
    public static TeamBean teamBean;
    public static TeamMemberBean teamMemberBean;
    public static TomatoBean tomatoBean;

    public static void initBean(Context Context) {
        requestQueue = Volley.newRequestQueue(Context);
        userBean = new UserBean(Context);
        commentBean = new CommentBean(Context);
        fileBean = new FileBean(Context);
        listBean = new ListBean(Context);
        logBean = new LogBean(Context);
        logTypeBean = new LogTypeBean(Context);
        memberBean = new MemberBean(Context);
        memberTaskBean = new MemberTaskBean(Context);
        projectBean = new ProjectBean(Context);
        projectMemberBean = new ProjectMemberBean(Context);
        serviceBean = new ServiceBean(Context);
        serviceUserMapBean = new ServiceUserMapBean(Context);
        taskBean = new TaskBean(Context);
        taskCheckItemBean = new TaskCheckItemBean(Context);
        teamBean = new TeamBean(Context);
        teamMemberBean = new TeamMemberBean(Context);
        tomatoBean = new TomatoBean(Context);
    }

    public static void clearBeanData(boolean if_user) {
        if (if_user) {
//            userBean.DeleteAll();
        }

    }

}
