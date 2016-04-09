package com.xcooper.Common.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.xcooper.vo.UserVO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "xcooper.db";

    private static final int DB_VERSION = 1;


    private Map<String, Dao> daos = new HashMap<String, Dao>();


    private static DBHelper instance;


    public static synchronized DBHelper getInstance(Context context) {
        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (DBHelper.class) {
                if (instance == null) {
                    instance = new DBHelper(context);
                }
            }
        }
        return instance;
    }



    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, UserVO.class);
//
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, UserVO.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (!daos.containsKey(className)) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        } else {
            dao = daos.get(className);
        }
        return dao;
    }


    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
