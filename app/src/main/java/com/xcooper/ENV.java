package com.xcooper;

public class ENV {

//    public static final String URL_IP_fuwu = "http://192.168.2.56:8080";

    public static final String URL_IP_fuwu = "http://192.168.99.182:8080";

    //新增任务
    public static String URL_ADD_TASK = URL_IP_fuwu + "/do?action=task.task!CAjaxAddTask";

    //新增项目
    public static String URL_ADD_PROJECT = URL_IP_fuwu + "/do?action=project.project!CAjaxAddProject";

    //得到成员
    public static String URL_GET_MEMBER = URL_IP_fuwu + "/do?action=sys.user.user!CAjaxQueryUser";

    //得到首页任务
    public static String URL_GET_TASK_INDEX = URL_IP_fuwu + "/do?action=task.task!CAjaxQueryTaskInIndex";

}
