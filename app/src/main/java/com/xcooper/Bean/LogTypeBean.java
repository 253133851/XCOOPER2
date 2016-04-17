package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.LogTypeVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class LogTypeBean {

    private Dao<LogTypeVO, Integer> LogTypeVOs;
    private DBHelper dbHelper;
    Context context;

    public LogTypeBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            LogTypeVOs = dbHelper.getDao(LogTypeVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(LogTypeVO LogTypeVO) {
        try {
            LogTypeVOs.create(LogTypeVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<LogTypeVO> query(String date, int state, int confirm) {
        List<LogTypeVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = LogTypeVOs.queryBuilder();
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
            LogTypeVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
