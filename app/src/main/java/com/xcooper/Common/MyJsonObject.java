package com.xcooper.Common;

import net.sf.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Iterator;


public class MyJsonObject {

    /**
     * 把一个jsonObject转换成一个bean
     *
     * @param jo
     * @param cls
     * @return
     */
    public static Object toBean(JSONObject jo, Class<?> cls) {
        Iterator<String> it = jo.keys();
        Object obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
        }
        while (it.hasNext()) {
            try {
                String name = it.next();
                Object o = jo.opt(name);
                setter(obj, updateFrist(name), o, cls.getDeclaredField(name).getType());
            } catch (Exception e) {
            }
        }
        return obj;
    }


    /**
     * @param obj   操作的对象
     * @param att   操作的属性
     * @param value 设置的值
     * @param type  参数的属性
     */
    private static void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {

        }
    }

    /**
     * 执行get方法
     *
     * @param obj
     * @param att
     */
    private static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将首字母改成大写
     *
     * @param fldName
     * @return
     */
    private static String updateFrist(String fldName) {
        String first = fldName.substring(0, 1).toUpperCase();
        String rest = fldName.substring(1, fldName.length());
        String newStr = new StringBuffer(first).append(rest).toString();
        return newStr;
    }


}
