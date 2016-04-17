package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.UserVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class UserBean {

    private Dao<UserVO, Integer> UserVOs;
    private DBHelper dbHelper;
    Context context;

    public UserBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            UserVOs = dbHelper.getDao(UserVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(UserVO UserVO) {
        try {
            UserVOs.create(UserVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<UserVO> query(String date, int state, int confirm) {
        List<UserVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = UserVOs.queryBuilder();
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
            UserVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
