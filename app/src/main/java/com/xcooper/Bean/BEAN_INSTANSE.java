package com.xcooper.Bean;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.sql.SQLException;

public class BEAN_INSTANSE {

    public static RequestQueue requestQueue;
//    public static UserBean userBean;

    public static void initBean(Context Context) {

        requestQueue = Volley.newRequestQueue(Context);
//        userBean = new UserBean(Context);

    }

    public static void clearBeanData(boolean if_user) {
        if (if_user) {
//            userBean.DeleteAll();
        }

    }

}
