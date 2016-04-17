package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.ServiceVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class ServiceBean {

    private Dao<ServiceVO, Integer> ServiceVOs;
    private DBHelper dbHelper;
    Context context;

    public ServiceBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            ServiceVOs = dbHelper.getDao(ServiceVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(ServiceVO ServiceVO) {
        try {
            ServiceVOs.create(ServiceVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<ServiceVO> query(String date, int state, int confirm) {
        List<ServiceVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = ServiceVOs.queryBuilder();
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
            ServiceVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
