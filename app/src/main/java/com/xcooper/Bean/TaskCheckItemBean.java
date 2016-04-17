package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.TaskCheckItemVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class TaskCheckItemBean {

    private Dao<TaskCheckItemVO, Integer> TaskCheckItemVOs;
    private DBHelper dbHelper;
    Context context;

    public TaskCheckItemBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            TaskCheckItemVOs = dbHelper.getDao(TaskCheckItemVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(TaskCheckItemVO TaskCheckItemVO) {
        try {
            TaskCheckItemVOs.create(TaskCheckItemVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<TaskCheckItemVO> query(String date, int state, int confirm) {
        List<TaskCheckItemVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TaskCheckItemVOs.queryBuilder();
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
            TaskCheckItemVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
