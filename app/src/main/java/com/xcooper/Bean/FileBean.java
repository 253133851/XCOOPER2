package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.FileVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class FileBean {

    private Dao<FileVO, Integer> FileVOs;
    private DBHelper dbHelper;
    Context context;

    public FileBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            FileVOs = dbHelper.getDao(FileVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(FileVO FileVO) {
        try {
            FileVOs.create(FileVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<FileVO> query(String date, int state, int confirm) {
        List<FileVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = FileVOs.queryBuilder();
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
            FileVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
