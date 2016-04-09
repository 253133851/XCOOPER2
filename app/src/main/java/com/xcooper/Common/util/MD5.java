/*
 * Created on 2005-6-15
 */
package com.xcooper.Common.util;


import java.security.MessageDigest;

/**
 * @author Dekn
 *         MD5加密
 */
public class MD5 {
    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) {
        String resultString = null;

        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            /**********************************************
             * 打乱MD5密码，把原有字符平分四份进行排序			*
             * 排序规则规则：2314 即第二份在第一位，第三份在第二位 *
             **********************************************/
            StringBuffer sb = new StringBuffer();
            sb.append(resultString.substring(8, 16)); //第二份
            sb.append(resultString.substring(16, 24)); //第三份
            sb.append(resultString.substring(0, 8)); //第一份
            sb.append(resultString.substring(24)); //第四份

            resultString = sb.toString();
        } catch (Exception ex) {

        }
        return resultString;
    }


}
