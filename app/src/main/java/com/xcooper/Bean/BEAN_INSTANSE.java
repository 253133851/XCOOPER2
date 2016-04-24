package com.xcooper.Bean;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.xcooper.Common.MyJsonObject;
import com.xcooper.Common.util.DateUtil;
import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.MyAsynctask;
import com.xcooper.fragment.mainFragment;
import com.xcooper.vo.MemberVO;
import com.xcooper.vo.ProjectVO;
import com.xcooper.vo.TaskVO;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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


    public static void loadTaskIndexData() {
        Method_Center.show_Toast("正在读取数据...", true);
        Map<String, String> map = new HashMap<String, String>();
        map.put("memberId", "10001");
        new MyAsynctask(map, ENV.URL_GET_TASK_INDEX) {
            @Override
            public void OK(JSONObject code) {
                insertTask(code);
                mainFragment.setLvData();
            }
        }.execute();
    }

    public static void insertTask(JSONObject result) {
        taskBean.updateOrDelete("delete from task where 1=1");
        projectBean.updateOrDelete("delete from project where 1=1");
        memberBean.updateOrDelete("delete from member where 1=1");

        JSONArray jsonArray = result.getJSONArray("extraData");
        System.out.println("开始读取");
        //我负责的任务
        JSONArray wofuzede = (JSONArray) jsonArray.get(0);
        for (int i = 0; i < wofuzede.size(); i++) {
            TaskVO task = (TaskVO) MyJsonObject.toBean((JSONObject) wofuzede.get(i), TaskVO.class);
            task.setType(TaskVO.task_wfzd);
            task.setEnd_DATETIME(longToDate(((JSONObject) wofuzede.get(i)).getLong("end_DATETIME")));
            taskBean.add(task);
        }
        //我创建的任务
        JSONArray wofaqide = (JSONArray) jsonArray.get(1);
        for (int i = 0; i < wofaqide.size(); i++) {
            TaskVO task = (TaskVO) MyJsonObject.toBean((JSONObject) wofaqide.get(i), TaskVO.class);
            task.setType(TaskVO.task_wfqd);
            task.setEnd_DATETIME(longToDate(((JSONObject) wofaqide.get(i)).getLong("end_DATETIME")));
            taskBean.add(task);
        }
        //我关注的任务
        JSONArray woguanzude = (JSONArray) jsonArray.get(2);
        for (int i = 0; i < woguanzude.size(); i++) {
            TaskVO task = (TaskVO) MyJsonObject.toBean((JSONObject) woguanzude.get(i), TaskVO.class);
            task.setType(TaskVO.task_wgzd);
            task.setEnd_DATETIME(longToDate(((JSONObject) woguanzude.get(i)).getLong("end_DATETIME")));
            taskBean.add(task);
        }

        //所有项目
        JSONArray xiangmu = (JSONArray) jsonArray.get(3);
        Map<Integer, ProjectVO> projectMap = new HashMap<>();
        for (int i = 0; i < xiangmu.size(); i++) {
            ProjectVO projectVO = (ProjectVO) MyJsonObject.toBean((JSONObject) xiangmu.get(i), ProjectVO.class);
            projectBean.add(projectVO);
            System.out.println(projectVO.toString());
            projectMap.put(projectVO.getProject_ID(), projectVO);
        }
        Constant.projectMap = projectMap;

        //所有成员
        JSONArray chengyuan = (JSONArray) jsonArray.get(4);
        Map<Integer, MemberVO> memberMap = new HashMap<>();
        for (int i = 0; i < chengyuan.size(); i++) {
            MemberVO memberVO = (MemberVO) MyJsonObject.toBean((JSONObject) chengyuan.get(i), MemberVO.class);
            memberBean.add(memberVO);
            memberMap.put(memberVO.getMember_ID(), memberVO);
        }
        Constant.memberMap = memberMap;

        Method_Center.show_Toast("读取成功...", true);
    }

    public static void main(String[] args) {
        String j = "[[{\"is_focus\":0,\"add_DATETIME\":null,\"del_DATETIME\":null,\"end_DATETIME\":null,\"update_DATETIME\":null,\"create_ID\":10002,\"task_ID\":10002,\"is_DEL\":0,\"exe_ID\":10001,\"task_NAME\":\"name1\",\"list_ID\":12,\"service_ID\":10001,\"task_INFO\":null,\"project_ID\":10002}]]";

        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(j);


        //我负责的任务
        net.sf.json.JSONArray wofuzede = (net.sf.json.JSONArray) jsonArray.get(0);
        for (int i = 0; i < wofuzede.size(); i++) {
            System.out.println(wofuzede.get(i).toString());
            TaskVO task = (TaskVO) MyJsonObject.toBean((JSONObject) wofuzede.get(i), TaskVO.class);
            task.setType(TaskVO.task_wfzd);
            System.out.println(task.toString());
        }

    }

    public static String longToDate(long time) {
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
}
