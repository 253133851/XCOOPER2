package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.MemberTaskVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class MemberTaskBean {

    private Dao<MemberTaskVO, Integer> MemberTaskVOs;
    private DBHelper dbHelper;
    Context context;

    public MemberTaskBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            MemberTaskVOs = dbHelper.getDao(MemberTaskVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(MemberTaskVO MemberTaskVO) {
        try {
            MemberTaskVOs.create(MemberTaskVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<MemberTaskVO> query(String date, int state, int confirm) {
        List<MemberTaskVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = MemberTaskVOs.queryBuilder();
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
            MemberTaskVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
