package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.TaskVO;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<TaskVO> query(String date, int state, int confirm) {
        List<TaskVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TaskVOs.queryBuilder();
            qb.where().eq("GOHOME_DATE", date)
                    .and().eq("STATE", state)
                    .and().eq("HAS_CONFIRM", confirm);
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

}
