package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.TeamVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class TeamBean {

    private Dao<TeamVO, Integer> TeamVOs;
    private DBHelper dbHelper;
    Context context;

    public TeamBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            TeamVOs = dbHelper.getDao(TeamVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(TeamVO TeamVO) {
        try {
            TeamVOs.create(TeamVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<TeamVO> query(String date, int state, int confirm) {
        List<TeamVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TeamVOs.queryBuilder();
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
            TeamVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
