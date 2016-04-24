package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.Common.util.DateUtil;
import com.xcooper.vo.TaskVO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class TaskBean {

    private Dao<TaskVO, Integer> TaskVOs;
    private DBHelper dbHelper;
    Context context;

    public TaskBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            TaskVOs = dbHelper.getDao(TaskVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(TaskVO TaskVO) {
        try {
            TaskVOs.create(TaskVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<TaskVO> query() {
        List<TaskVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TaskVOs.queryBuilder();
            list = qb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * query
     */
    public List<TaskVO> query(int type) {
        List<TaskVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TaskVOs.queryBuilder();
            qb.where().eq("type", type);
            list = qb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * update
     */
    public void updateOrDelete(String sql) {
        try {
            TaskVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String d2 = "1461487697000";
        System.out.println(stringToDate(d2));
        String d = "1460865600000";
        System.out.println(DateUtil.format(Timestamp.valueOf(d), "yyyy-MM-dd HH:mm:ss"));
        String d0 = "1460865600000";
        System.out.println(DateUtil.format(Timestamp.valueOf(d0), "yyyy-MM-dd HH:mm:ss"));
    }

    public static String stringToDate(String lo){
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
}
