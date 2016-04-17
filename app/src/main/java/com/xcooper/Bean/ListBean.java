package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.ListVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class ListBean {

    private Dao<ListVO, Integer> ListVOs;
    private DBHelper dbHelper;
    Context context;

    public ListBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            ListVOs = dbHelper.getDao(ListVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(ListVO ListVO) {
        try {
            ListVOs.create(ListVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<ListVO> query(String date, int state, int confirm) {
        List<ListVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = ListVOs.queryBuilder();
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
            ListVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
