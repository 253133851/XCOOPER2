package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.MemberVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class MemberBean {

    private Dao<MemberVO, Integer> MemberVOs;
    private DBHelper dbHelper;
    Context context;

    public MemberBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            MemberVOs = dbHelper.getDao(MemberVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(MemberVO MemberVO) {
        try {
            MemberVOs.create(MemberVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<MemberVO> query(String date, int state, int confirm) {
        List<MemberVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = MemberVOs.queryBuilder();
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
            MemberVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
