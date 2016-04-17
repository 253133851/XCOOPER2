package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.ProjectVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class ProjectBean {

    private Dao<ProjectVO, Integer> ProjectVOs;
    private DBHelper dbHelper;
    Context context;

    public ProjectBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            ProjectVOs = dbHelper.getDao(ProjectVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(ProjectVO ProjectVO) {
        try {
            ProjectVOs.create(ProjectVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<ProjectVO> query(String date, int state, int confirm) {
        List<ProjectVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = ProjectVOs.queryBuilder();
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
            ProjectVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
