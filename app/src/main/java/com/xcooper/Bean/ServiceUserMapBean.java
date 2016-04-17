package com.xcooper.Bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.xcooper.Common.data.DBHelper;
import com.xcooper.vo.ServiceUserMapVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26901 on 2016.4.17.
 */
public class ServiceUserMapBean {

    private Dao<ServiceUserMapVO, Integer> ServiceUserMapVOs;
    private DBHelper dbHelper;
    Context context;

    public ServiceUserMapBean(Context context) {
        this.context = context;
        try {
            dbHelper = DBHelper.getInstance(context);
            ServiceUserMapVOs = dbHelper.getDao(ServiceUserMapVO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add
     */
    public void add(ServiceUserMapVO ServiceUserMapVO) {
        try {
            ServiceUserMapVOs.create(ServiceUserMapVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * query
     */
    public List<ServiceUserMapVO> query(String date, int state, int confirm) {
        List<ServiceUserMapVO> list = new ArrayList<>();
        try {
            QueryBuilder qb = ServiceUserMapVOs.queryBuilder();
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
            ServiceUserMapVOs.updateRaw(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
