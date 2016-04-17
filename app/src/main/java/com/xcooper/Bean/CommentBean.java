package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.CommentVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class CommentBean {

    private Dao<CommentVO, Integer> commentVOs;
    private DBHelper dbHelper;
    Context context;

    public CommentBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            commentVOs = dbHelper.getDao(CommentVO.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(CommentVO commentVO) {
        try {
            commentVOs.create(commentVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<CommentVO> query(String date, int state, int confirm) {
        List<CommentVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = commentVOs.queryBuilder();
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
            commentVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
