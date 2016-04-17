package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.TomatoVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class TomatoBean {

    private Dao<TomatoVO, Integer> TomatoVOs;
    private DBHelper dbHelper;
    Context context;

    public TomatoBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            TomatoVOs = dbHelper.getDao(TomatoVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(TomatoVO TomatoVO) {
        try {
            TomatoVOs.create(TomatoVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<TomatoVO> query(String date, int state, int confirm) {
        List<TomatoVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TomatoVOs.queryBuilder();
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
            TomatoVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
