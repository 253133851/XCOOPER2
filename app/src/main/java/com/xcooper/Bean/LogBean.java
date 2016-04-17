package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.LogVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class LogBean {

    private Dao<LogVO, Integer> LogVOs;
    private DBHelper dbHelper;
    Context context;

    public LogBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            LogVOs = dbHelper.getDao(LogVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(LogVO LogVO) {
        try {
            LogVOs.create(LogVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<LogVO> query(String date, int state, int confirm) {
        List<LogVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = LogVOs.queryBuilder();
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
            LogVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
