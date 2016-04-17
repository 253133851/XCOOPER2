package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.ProjectMemberVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class ProjectMemberBean {

    private Dao<ProjectMemberVO, Integer> ProjectMemberVOs;
    private DBHelper dbHelper;
    Context context;

    public ProjectMemberBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            ProjectMemberVOs = dbHelper.getDao(ProjectMemberVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(ProjectMemberVO ProjectMemberVO) {
        try {
            ProjectMemberVOs.create(ProjectMemberVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<ProjectMemberVO> query(String date, int state, int confirm) {
        List<ProjectMemberVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = ProjectMemberVOs.queryBuilder();
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
            ProjectMemberVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
