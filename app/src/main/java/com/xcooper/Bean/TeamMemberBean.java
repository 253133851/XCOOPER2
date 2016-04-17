package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.TeamMemberVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class TeamMemberBean {

    private Dao<TeamMemberVO, Integer> TeamMemberVOs;
    private DBHelper dbHelper;
    Context context;

    public TeamMemberBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            TeamMemberVOs = dbHelper.getDao(TeamMemberVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(TeamMemberVO TeamMemberVO) {
        try {
            TeamMemberVOs.create(TeamMemberVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<TeamMemberVO> query(String date, int state, int confirm) {
        List<TeamMemberVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = TeamMemberVOs.queryBuilder();
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
            TeamMemberVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
