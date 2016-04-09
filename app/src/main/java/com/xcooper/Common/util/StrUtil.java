/*
 * ������ 2004-10-25 20:06:55
 * JCMS
 */
package com.xcooper.Common.util;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dekn
 *         <p/>
 *         �ַ���������
 *         <p/>
 *         JCMS ( Content Manager System for java )
 */
public class StrUtil {

    private static String varStr = "@";

    /**
     * �滻ģ���е��ַ�
     *
     * @param str        ԭ�ַ���
     * @param templetStr Ҫ�滻��ģ���ַ�
     * @param data       �滻��ʲô�ַ�
     * @return
     */
    public static String replaceAllForTemplet(String str, String templetStr,
                                              String data) {
        String s = replaceAll(str, varStr + templetStr, data);
        return s;
    }

    /**
     * ȡ��һ���ǿյ�����ֵ������ṩ������Ϊ�ջ���Ϊ��ĸ�����Զ�ת��Ϊ0
     *
     * @param data ��Ҫת��������
     * @return
     */
    public static int getNotNullIntValue(String data) {
        int value = 0;
        try {
            value = Integer.parseInt(data);
//            if (value < 0){
//                value = 0;
//            }
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }

    /**
     * ȡ��һ���ǿյ�����ֵ������ṩ������Ϊ�ջ���Ϊ��ĸ���򷵻�returnValue
     *
     * @param date
     * @param returnValue
     * @return
     */
    public static int getNotNullIntValue(String date, int returnValue) {
        int value = getNotNullIntValue(date);
        if (value == 0) {
            value = returnValue;
        }
        return value;
    }

    /**
     * ȡ��һ���ǿյ�ʱ���������ṩ������Ϊ�ջ�ΪNULL�����Զ�ȡ��ǰʱ��
     *
     * @param data
     * @param dateFormat TODO
     * @return
     */
    public static Timestamp getNotNullTimestampValue(String data, String dateFormat) {
        Timestamp value;
        try {
            if (null == data || data.equals("")) {
                value = new Timestamp(System.currentTimeMillis());
            } else {
                SimpleDateFormat smd = new SimpleDateFormat(dateFormat);
                value = new Timestamp(smd.parse(data).getTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
            value = new Timestamp(System.currentTimeMillis());
        }

        return value;
    }

    /**
     * ����һ���ǿյ��ַ���������ַ���Ϊ�ջ�ΪNULL���򷵻�returnValue
     *
     * @param date
     * @param returnValue ����ַ���Ϊ�ջ�ΪNULL���򷵻�returnValue
     * @return
     */
    public static String getNotNullStringValue(String date, String returnValue) {
        String value = date;
        if (date == null || date.trim().equals("")) {
            value = returnValue;
        }
        return value;
    }

    /**
     * ����һ���ǿյ��ַ���������ַ���Ϊ�գ���ֱ�ӷ��ء��������ַ�����null)
     *
     * @param date
     * @return
     */
    public static String getNotNullStringValue(String date) {
        String value = date;
        if (date == null || date.trim().equals("")) {
            return "";
        }
        return value;
    }

    /**
     * �ж�һ���ַ����ǲ�������
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        boolean isNumber = true;
        try {
            int tmp = Integer.parseInt(str.trim());
            if (tmp < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return isNumber;
    }


    /**
     * �ж�һ���ַ����ǲ���FLOAT���͵�����
     *
     * @param str
     * @return
     */
    public static boolean isFloat(String str) {
        boolean isFloat = true;
        try {
            float tmp = Float.parseFloat(str.trim());
            if (tmp < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return isFloat;
    }


    /**
     * �ַ��滻����
     *
     * @param source
     * @param oldString
     * @param newString
     * @return
     */
    public static String replaceAll(String source, String oldString, String newString) {
        //���滻�ַ�Ϊ�գ�����Դ�ַ���
        if (null == oldString || oldString.equals("")) {
            return source;
        }
        //ԴΪ�գ�����null
        if (isNull(source)) {
            return "";
        }

        StringBuffer output = new StringBuffer();
        int lengOfsource = source.length();
        int lengOfold = oldString.length();
        int posStart = 0;
        int pos;
        while ((pos = source.indexOf(oldString, posStart)) >= 0) {
            output.append(source.substring(posStart, pos));
            output.append(newString);
            posStart = pos + lengOfold;
        }
        if (posStart < lengOfsource) {
            output.append(source.substring(posStart));
        }
        return output.toString();
    }


    /**
     * �滻���пո�
     *
     * @param source
     * @return
     */
    public static String replaceAllSpace(String source) {
        return replaceAll(source, " ", "");
    }

    /**
     * ����ַ����Ƿ���Ϲ���
     *
     * @param source
     * @return
     */
    public static boolean checkStringRule(String source) {
        boolean isOK = true;

        if (null == source || source.trim().equals("")) {
            return true;
        }

        if (source.indexOf("<") > -1 ||
                source.indexOf(">") > -1 ||
                source.indexOf(".") > -1 ||
                source.indexOf("\"") > -1 ||
                source.indexOf("\'") > -1 ||
                source.indexOf(",") > -1 ||
                source.indexOf("$") > -1 ||
                source.indexOf("#") > -1 ||
                source.indexOf("%") > -1 ||
                source.indexOf("!") > -1 ||
                source.indexOf("~") > -1 ||
                source.indexOf("^") > -1 ||
                source.indexOf("&") > -1 ||
                source.indexOf("*") > -1 ||
                source.indexOf("(") > -1 ||
                source.indexOf(")") > -1 ||
                source.indexOf("=") > -1 ||
                source.indexOf("+") > -1 ||
                source.indexOf("|") > -1 ||
                source.indexOf("\\") > -1 ||
                source.indexOf(";") > -1 ||
                source.indexOf(":") > -1 ||
                source.indexOf("?") > -1 ||
                source.indexOf("��") > -1
                )

            isOK = false;


        return isOK;
    }


    /**
     * ��HTML���б��룬�Ա�ǰ̨PAGE����������ʾ
     *
     * @param str Ҫ������ַ���
     * @return
     */
    public static String encodeHTML(String str) {
        if (null == str) {
            return str;
        }
        String s = str;
        s = replaceAll(s, "\"", "&quot;");
        s = replaceAll(s, "<", "&lt;");
        s = replaceAll(s, ">", "&gt;");
        s = replaceAll(s, "'", "&#39;");
        return s;
    }


    /**
     * HTML����
     *
     * @param str
     * @return
     * @author lala 2008-2-21 ����05:01:21
     */
    public static String decodeHTML(String str) {
        if (isNull(str))
            return "";

        String s = str;
        s = replaceAll(s, "&quot;", "\"");
        s = replaceAll(s, "&lt;", "<");
        s = replaceAll(s, "&gt;", ">");
        return s;
    }

    /**
     * �ַ���ת����Vector,�ַ��������Զ��ŷָ�.
     *
     * @param str
     * @return
     */
    public static Vector strToVector(String str) {
        Vector v = new Vector();

        if (null == str || str.trim().equals("")) {
            return v;
        }

        String[] str_array = str.split("\\,");

        for (int i = 0; i < str_array.length; i++) {
            String tmp = str_array[i].trim().toLowerCase();
            if (null != tmp && !tmp.equals("")) {
                v.add(tmp);
            }
        }

        return v;
    }

    /**
     * ��һ���ַ������飬ת��Ϊһ���ַ���
     *
     * @param strArray
     * @param splitStr ת�����ַ���ʱ��������Ԫ��֮��ķָ���
     * @return
     */
    public static String strArrayToStr(String[] strArray, String splitStr) {
        String str = "";
        if (null == strArray || strArray.length <= 0) {
            return "";
        }

        for (int i = 0; i < strArray.length; i++) {
            if (str.length() > 0) {
                str = str + "," + strArray[i];
            } else {
                str = strArray[i];
            }
        }

        return str;
    }


    /**
     * ���ַ�������ת����Vector
     *
     * @param str_array
     * @return
     */
    public static Vector strArrayToVector(String[] str_array) {
        Vector v = new Vector();

        if (null == str_array || str_array.length == 0) {
            return v;
        }

        for (int i = 0; i < str_array.length; i++) {
            String tmp = str_array[i].trim();
            if (null != tmp && !tmp.equals("")) {
                v.add(tmp);
            }
        }

        return v;
    }


    /**
     * �ϲ�����vector�����շ���һ���µĺϲ����vector
     *
     * @param v1
     * @param v2
     * @return
     */
    public static Vector vectorUnite(Vector v1, Vector v2) {
        Vector over = new Vector();

        over.addAll(v1);
        over.addAll(v2);

        return over;
    }


    /**
     * ��hashmapת����collection
     * �˷���ֻ�ܽ�hashmap�е�ֵ����collection��
     *
     * @param map
     * @return
     */
    public static Collection mapToCollection(HashMap map) {
        return map.values();
    }


    /**
     * �ж��ṩ���ַ�����Ϊ�ջ�NULL
     *
     * @return
     */
    public static boolean isNull(String str) {
        if (null == str || str.trim().equals("")) {
            return true;
        }

        return false;
    }


    /**
     * �ж��ṩ���ַ����ǲ��ǲ�Ϊ�ջ�NULL
     *
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {
        if (null == str || str.trim().equals("")) {
            return false;
        }

        return true;
    }


    /**
     * �ṩ���ַ��Ƿ�Ƚ������
     *
     * @param str
     * @return
     */
    public static boolean isCompareStr(String str) {
        boolean b = false;

        if (isNull(str)) {
            return false;
        }

        if (str.equals("<") || str.equals(">") || str.equals(">=") || str.equals("<=") || str.equals("=") || str.equals("==")) {
            b = true;
        }

        return b;
    }


    /**
     * ȥ���Ƿ��ַ�
     *
     * @param str
     * @return
     */
    public static String removeLawlessStr(String str) {

        if (null == str || str.trim().equals("")) {
            return str;
        }

        String overStr = str;

        overStr = StrUtil.replaceAll(overStr, "'", "");
        overStr = StrUtil.replaceAll(overStr, "%", "");
        overStr = StrUtil.replaceAll(overStr, "SELECT", "[SELECT]");
        overStr = StrUtil.replaceAll(overStr, "UPDATE", "[UPDATE]");
        overStr = StrUtil.replaceAll(overStr, "DELETE", "[DELETE]");

        return overStr;
    }

    /**
     * ����HTML TAG
     *
     * @param str
     * @return
     */
    public static String removeHTMLTAG(String str) {
        int beginHtml, endHtml;
        StringBuffer content = new StringBuffer(str);
        while (true) {
            beginHtml = content.indexOf("<");
            endHtml = content.indexOf(">");
            if (beginHtml >= 0 && endHtml >= 0 && beginHtml < endHtml) {
                content = content.replace(beginHtml, endHtml + 1, "");
            } else {
                break;
            }
        }

        return content.toString();
    }


    /**
     * ����HTML����ȥ���Ƿ��ַ�
     *
     * @param str
     * @return
     */
    public static String encodeHTMLAndRemoveLawlessStr(String str) {
        String s = encodeHTML(str);
        return removeLawlessStr(s);
    }

    /**
     * ��һ���ַ�������ֳ�һ��ArrayList
     *
     * @param c
     * @param str
     * @return
     */
    public static ArrayList split(String str, char c) {
        if (str == null) {
            return null;
        }
        ArrayList tmp = new ArrayList();
        String temp = null;
        int kk = 0;
        int tt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                kk = i;
                temp = str.substring(tt, kk);
                tmp.add(temp);
                tt = i + 1;
            }
        }
        if (tt < str.length()) {
            tmp.add(str.substring(tt));
        }
        if (tmp.size() <= 0) {
            return null;
        }
        return tmp;
    }

    /**
     * ��Vectorת���ɰ�Ƕ��ŷָ����ַ���
     *
     * @param v
     * @return
     * @author dekn 2007-9-1 1:25:39
     */
    public static String vectorToStr(Vector v) {
        String s = "";

        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            String tmp = (String) e.nextElement();
            if (s.length() > 0) {
                s = s + "," + tmp;
            } else {
                s = tmp;
            }
        }

        return s;
    }


    /**
     * ȡ�ַ�����ǰtoCount���ַ�
     *
     * @param str     �������ַ���
     * @param toCount ��ȡ����
     * @param more    ��׺�ַ���
     * @return String
     * @version 2004.11.24
     * @author zhulx
     */
    public static String substring(String str, int toCount, String more) {
        int reInt = 0;
        String reStr = "";
        if (null == str) {
            return "";
        }

        char[] tempChar = str.toCharArray();
        for (int kk = 0; (kk < tempChar.length && toCount > reInt); kk++) {
            String s1 = str.valueOf(tempChar[kk]);
            byte[] b = s1.getBytes();
            reInt += b.length;
            reStr += tempChar[kk];
        }

        if (toCount == reInt || (toCount == reInt - 1)) {
            reStr += more;
        }
        return reStr;
    }


    /**
     * ���ܣ��������Ƴ��Ƚ�ȡ�ַ������ַ����а������֣�һ�����ֵ��������ַ���
     * @param strParameter Ҫ��ȡ���ַ���
     * @param limitLength ��ȡ�ĳ���
     * @return ��ȡ����ַ���
     */


    /**
     * ȡ��һ���ַ����ĳ��ȣ����ֽڣ�
     *
     * @param str
     * @return
     * @author dekn   2007-9-20 ����09:59:11
     */
    public static int getLength(String str) {
        int length = str.length();

        try {
            length = str.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return length;
    }

    /**
     * �ж�ĳ���ַ������Ƿ����ַ������У������ִ�Сд
     *
     * @param array
     * @param str
     * @return
     * @author dekn   2007-10-26 ����12:07:25
     */
    public static boolean isHasInArray(String[] array, String str) {
        boolean is = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(str)) {
                return true;
            }
        }

        return is;
    }

    /**
     * ȡ��hashMap��key������ַ�������,�ָ�
     *
     * @param map
     * @return
     * @author dekn   2008-6-6 ����10:36:25
     */
    public static String getMapKeyStr(HashMap map) {
        Iterator it = map.keySet().iterator();
        String over = "";

        while (it.hasNext()) {
            String key = (String) it.next();
            if (over.equals("")) {
                over = key;
            } else {
                over = over + "," + key;
            }
        }

        return over;
    }

    /**
     * ȡ��hashMap��value������ַ�������,�ָ�
     *
     * @param map
     * @return
     * @author dekn   2008-6-6 ����10:36:25
     */
    public static String getMapValueStr(HashMap map) {
        Iterator it = map.values().iterator();
        String over = "";

        while (it.hasNext()) {
            String value = (String) it.next();
            if (over.equals("")) {
                over = value;
            } else {
                over = over + "," + value;
            }
        }

        return over;
    }


    /**
     * ת��sql�еĹؼ���
     *
     * @param str
     * @return
     * @author dekn   2008-11-13 ����07:03:51
     */
    public static String encodeSqlStr(String str) {
        if (isNull(str))
            return "";

        String s = str;

        s = replaceAll(s, "'", "\\'");    //��'ת���\'

        return s;
    }


    /**
     * �ж��ַ������Ƿ�������
     *
     * @param source
     * @return
     * @author lala 2009-8-17 ����02:13:11
     */
    public static boolean isChinese(String source) {
        boolean retPar = false;

        String regex = "[^u4E00-u9FA5]+";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(source);

        if (matcher.find()) {
            retPar = true;
        }

        return retPar;
    }

    /**
     * ȡ��һ���ǿյĸ�����������ṩ������Ϊ�ջ���Ϊ��ĸ�����Զ�ת��Ϊ0.00
     *
     * @param data ��Ҫת��������
     * @return
     */
    public static float getNotNullFloatValue(String data) {
        float value = 0.0f;
        try {
            value = Float.parseFloat(data);
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }

    /**
     * ȡ��һ���ǿյĸ�����������ṩ������Ϊ�ջ���Ϊ��ĸ���򷵻�returnValue
     *
     * @param date
     * @param returnValue
     * @return
     */
    public static float getNotNullFloatValue(String date, float returnValue) {
        float value = getNotNullFloatValue(date);
        if (value == 0.0f) {
            value = returnValue;
        }
        return value;
    }

    /**
     * �������Ϊnull,����" "
     *
     * @return
     */
    public static String getNullValueStr(String str) {
        if (isNull(str)) {
            return " ";
        } else {
            return str;
        }
    }

    /**
     * ȡ��һ���ǿյĸ�����������ṩ������Ϊ�ջ���Ϊ��ĸ�����Զ�ת��Ϊ0.00
     *
     * @param data ��Ҫת��������
     * @return
     */
    public static double getNotNullDoubleValue(String data) {
        double value = 0.00;
        try {
            value = Double.parseDouble(data);
        } catch (NumberFormatException e) {
            value = 0.00;
        }
        return value;
    }

    /**
     * ȡ��һ���ǿյĸ�����������ṩ������Ϊ�ջ���Ϊ��ĸ���򷵻�returnValue
     *
     * @param date
     * @param returnValue
     * @return
     */
    public static double getNotNullDoubleValue(String date, double returnValue) {
        double value = getNotNullDoubleValue(date);
        if (value == 0.00) {
            value = returnValue;
        }
        return value;
    }

    /***
     * ȡĿ��STRָ����ʼ�ַ���������ַ����м���ַ���
     *
     * @param targetStr
     * @param startStr
     * @param endStr    ��Ϊ"",Ϊ""��ʾ��ȡ��startStr�Ժ�������ַ���
     * @param isBlur    �Ƿ�ʹ��ģ����ȡ
     * @return
     * @author lala 2008-10-24 ����03:50:09
     */
    public static String getMiddleStr(String targetStr, String startStr, String endStr, boolean isBlur) {
        String returnStr = targetStr;

        int startIndex = -1;
        if (isNotNull(startStr))
            startIndex = returnStr.indexOf(startStr);

        int endIndex = -1;
        if (isNotNull(endStr))
            endIndex = returnStr.indexOf(endStr);

        if (isBlur == false) {
            /***************************************************
             * 				��ȷ��ȡ							   *
             ***************************************************/
            if (startIndex < 0 || endIndex < 0) {
                return "";
            }

            //ȷ�������ַ�һ���ڿ�ʼ�ַ�֮��
            if (startIndex > endIndex) {
                returnStr = returnStr.substring(startIndex + startStr.length(), returnStr.length());//�ȴӿ�ʼ�ĵط���ȡ
                endIndex = returnStr.indexOf(endStr);
                if (endIndex < 0)
                    return "";
                returnStr = returnStr.substring(0, endIndex);
            } else {
                returnStr = returnStr.substring(startIndex + startStr.length(), endIndex);
            }
        } else {

            /***************************************************
             * 				ģ����ȡ							   *
             ***************************************************/
            if (startIndex > endIndex) {
                return "";
            }
            if (startIndex > -1)
                returnStr = returnStr.substring(startIndex + startStr.length(), returnStr.length());//�ȴӿ�ʼ�ĵط���ȡ
            if (endIndex > -1)
                returnStr = returnStr.substring(0, endIndex);
        }


        return returnStr;
    }

    /***
     * ��ȷ��ȡ
     * ȡĿ��STRָ����ʼ�ַ���������ַ����м���ַ���
     *
     * @param targetStr
     * @param startStr
     * @param endStr    ��Ϊ"",Ϊ""��ʾ��ȡ��startStr�Ժ�������ַ���
     * @return
     * @author lala 2008-10-24 ����03:50:09
     */
    public static String getMiddleStr(String targetStr, String startStr, String endStr) {
        return getMiddleStr(targetStr, startStr, endStr, false);
    }

    /**
     * ȡ��hashMap��value������ַ�������'�ָ�
     * ����ר��Ϊ��չ�ֶ�MAP�ṩ�ķ�����������չ�ֶ��г���Ӣ�Ķ��ŵ�
     * ���Ὣһ�����ݷֳ���������
     *
     * @param map
     * @return
     */
    public static String getMapValueStrForExt(HashMap map) {
        Iterator it = map.values().iterator();
        String over = "";

        while (it.hasNext()) {
            String value = (String) it.next();
            if (over.equals("")) {
                over = value;
            } else {
                over = over + "@;@" + value;
            }
        }

        return over;
    }

    /**
     * ȡ��һ���ǿյĳ�����������ṩ������Ϊ�ջ���Ϊ��ĸ�����Զ�ת��Ϊ0
     *
     * @param data ��Ҫת��������
     * @return
     */
    public static long getNotNullLongValue(String data) {
        long value = 0;
        try {
            value = Long.parseLong(data);
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }

    /**
     * ȡ��һ���ǿյĳ�������������ṩ������Ϊ�ջ���Ϊ��ĸ���򷵻�returnValue
     *
     * @param date
     * @param returnValue
     * @return
     */
    public static long getNotNullLongValue(String date, long returnValue) {
        long value = getNotNullLongValue(date);
        if (value == 0) {
            value = returnValue;
        }
        return value;
    }

    /**
     * ������%D6%D0%B9%FA�ַ�����
     *
     * @param target
     * @param enc
     * @return
     * @author lala 2009-12-31 ����03:25:17
     */
    public static String decodeURI(String target, String enc) {

        String returnStr = "";

        try {
            returnStr = java.net.URLDecoder.decode(target, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }

        return returnStr;
    }

    /**
     * ��һ���ַ��͵�Collectionת��Ϊһ���ַ���
     *
     * @param splitStr
     * @return
     * @author dekn  2011-8-29 ����02:35:25
     */
    public static String strCollToStr(Collection strCollection, String splitStr) {
        String str = "";
        if (null == strCollection || strCollection.size() <= 0) {
            return "";
        }

        Iterator it = strCollection.iterator();
        while (it.hasNext()) {
            String value = (String) it.next();
            if (str.length() > 0) {
                str = str + "," + value;
            } else {
                str = value;
            }
        }

        return str;
    }

    /**
     * @param value
     * @return
     */
    public static String addZeroAtNumHead(String value) {
        return addZeroAtNumHead(value, 12);
    }


    /**
     * �������ַ���ǰ���Զ���0 ����100.69 ת������00000000010069 100��ת������00000000010000
     *
     * @param value
     * @param length ��0�������λ����
     * @return
     */
    public static String addZeroAtNumHead(String value, int length) {
        if (isNull(value)) {
            return "";
        }

        int intLength = value.indexOf(".");    //����λ�ĳ���
        //����Ǹ�������ֵ ��90.00��ת��Ϊ000000090.00��С��1��С��ֱ�ӷ���
        if (intLength > 0) {
            String str1 = value.substring(0, intLength);    //��������

            String str2 = value.substring(intLength + 1);//С������

            /**
             * С��λ�Ĵ���
             * ��ֱ�ӳ���100������Ϊ�˲�Ӱ��value�����ֵ����
             */
            //���str2�ǿ� ��ֵΪ00
            if (isNull(str2)) {
                str2 = "00";
            }
            //�����1λС�� ���ڰٷ�λ�ϲ�0
            if (str2.length() == 1) {
                str2 = str2.substring(0, 1) + "0";
                //���ڵ�����λС���ģ�ֻȡǰ��λ
            } else {
                str2 = str2.substring(0, 2);
            }

            /**
             * ����λ�Ĵ���
             */
            //����������ֵĳ��ȴ�����Ҫ�ĳ��ȣ���ֱ�ӷ���
            if (length < intLength) {
                return value;
                //������λǰ�油0���ټ���ԭ����С��λ�󷵻�
            } else {
                int cha = length - intLength;
                String zero = "";
                for (int i = 0; i < cha; i++) {
                    zero += "0";
                }
                return zero + str1 + str2;
            }
            //���ε���ֵ
        } else {
            int valueLength = value.length();    //���ֵĳ���
            if (length < valueLength) {
                return value;
            }
            int cha = length - valueLength;
            String zero = "";
            for (int i = 0; i < cha; i++) {
                zero += "0";
            }
            return zero + value + "00";
        }

    }


    /**
     * ���ַ������С���� ��ȷ��С���������λ
     *
     * @param value
     * @return
     */
    public static String addPoint(String value) {
        return addPoint(value, 2);
    }


    /**
     * ���վ��ȸ��ַ������С����
     *
     * @param value
     * @param jd    ����
     * @return
     */
    public static String addPoint(String value, int jd) {
        if (isNull(value)) {
            return "";
        }

        if (value.indexOf(".") >= 0) {
            return value;
        }

        int length = value.length();

        if (length < jd) {
            return value;
        }

        //���վ��ȣ����С����
        String returnStr = value.substring(0, length - jd) + "." + value.substring(length - jd);

        return returnStr;
    }


    /**
     * ����Ĵ���
     */
    public static String getMD5Password(String psw_forMD5,long time) {
        return MD5.MD5Encode(psw_forMD5 + time);
    }

}
