package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 用户VO
 *
 * @author zdk
 *         2016-03-28 19:20:05
 */
@DatabaseTable(tableName = "user")
public class UserVO {

    //用户ID
    @DatabaseField
    int UID;

    //登录ID
    @DatabaseField
    int LOGIN_ID;

    //密码
    @DatabaseField
    String PWD;

    //注册日期
    @DatabaseField
    Timestamp REG_DATETIME;

    //登录次数
    @DatabaseField
    int LOGINS;

    //最后登录时间
    @DatabaseField
    Timestamp LAST_LOGIN_DATETIME;

    //最后登录IP
    @DatabaseField
    String LAST_LOGIN_IP;

    //密码问题
    @DatabaseField
    String QUESTION;

    //问题答案
    @DatabaseField
    String ANSWER;

    //用户状态
    @DatabaseField
    int STATE;

    //EMAIL
    @DatabaseField
    String EMAIL;

    //头像
    @DatabaseField
    String FACE_URL;

    //个人说明/签名
    @DatabaseField
    String USER_REMARK;

    //注册验证码
    @DatabaseField
    String REG_VILIDATE_CODE;

    //手机号
    @DatabaseField
    String PHONE;

    /**
     * @return 返回 UID 用户ID
     */
    public int getUID() {
        return UID;
    }

    /**
     * @param UID 设置 UID 的值
     */
    public void setUID(int UID) {
        this.UID = UID;
    }

    /**
     * @return 返回 LOGIN_ID 登录ID
     */
    public int getLOGIN_ID() {
        return LOGIN_ID;
    }

    /**
     * @param LOGIN_ID 设置 LOGIN_ID 的值
     */
    public void setLOGIN_ID(int LOGIN_ID) {
        this.LOGIN_ID = LOGIN_ID;
    }

    /**
     * @return 返回 PWD 密码
     */
    public String getPWD() {
        return PWD;
    }

    /**
     * @param PWD 设置 PWD 的值
     */
    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    /**
     * @return 返回 REG_DATETIME 注册日期
     */
    public Timestamp getREG_DATETIME() {
        return REG_DATETIME;
    }

    /**
     * @param REG_DATETIME 设置 REG_DATETIME 的值
     */
    public void setREG_DATETIME(Timestamp REG_DATETIME) {
        this.REG_DATETIME = REG_DATETIME;
    }

    /**
     * @return 返回 LOGINS 登录次数
     */
    public int getLOGINS() {
        return LOGINS;
    }

    /**
     * @param LOGINS 设置 LOGINS 的值
     */
    public void setLOGINS(int LOGINS) {
        this.LOGINS = LOGINS;
    }

    /**
     * @return 返回 LAST_LOGIN_DATETIME 最后登录时间
     */
    public Timestamp getLAST_LOGIN_DATETIME() {
        return LAST_LOGIN_DATETIME;
    }

    /**
     * @param LAST_LOGIN_DATETIME 设置 LAST_LOGIN_DATETIME 的值
     */
    public void setLAST_LOGIN_DATETIME(Timestamp LAST_LOGIN_DATETIME) {
        this.LAST_LOGIN_DATETIME = LAST_LOGIN_DATETIME;
    }

    /**
     * @return 返回 LAST_LOGIN_IP 最后登录IP
     */
    public String getLAST_LOGIN_IP() {
        return LAST_LOGIN_IP;
    }

    /**
     * @param LAST_LOGIN_IP 设置 LAST_LOGIN_IP 的值
     */
    public void setLAST_LOGIN_IP(String LAST_LOGIN_IP) {
        this.LAST_LOGIN_IP = LAST_LOGIN_IP;
    }

    /**
     * @return 返回 QUESTION 密码问题
     */
    public String getQUESTION() {
        return QUESTION;
    }

    /**
     * @param QUESTION 设置 QUESTION 的值
     */
    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    /**
     * @return 返回 ANSWER 问题答案
     */
    public String getANSWER() {
        return ANSWER;
    }

    /**
     * @param ANSWER 设置 ANSWER 的值
     */
    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    /**
     * @return 返回 STATE 用户状态
     */
    public int getSTATE() {
        return STATE;
    }

    /**
     * @param STATE 设置 STATE 的值
     */
    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    /**
     * @return 返回 EMAIL EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param EMAIL 设置 EMAIL 的值
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /**
     * @return 返回 FACE_URL 头像
     */
    public String getFACE_URL() {
        return FACE_URL;
    }

    /**
     * @param FACE_URL 设置 FACE_URL 的值
     */
    public void setFACE_URL(String FACE_URL) {
        this.FACE_URL = FACE_URL;
    }

    /**
     * @return 返回 USER_REMARK 个人说明/签名
     */
    public String getUSER_REMARK() {
        return USER_REMARK;
    }

    /**
     * @param USER_REMARK 设置 USER_REMARK 的值
     */
    public void setUSER_REMARK(String USER_REMARK) {
        this.USER_REMARK = USER_REMARK;
    }

    /**
     * @return 返回 REG_VILIDATE_CODE 注册验证码
     */
    public String getREG_VILIDATE_CODE() {
        return REG_VILIDATE_CODE;
    }

    /**
     * @param REG_VILIDATE_CODE 设置 REG_VILIDATE_CODE 的值
     */
    public void setREG_VILIDATE_CODE(String REG_VILIDATE_CODE) {
        this.REG_VILIDATE_CODE = REG_VILIDATE_CODE;
    }

    /**
     * @return 返回 PHONE 手机号
     */
    public String getPHONE() {
        return PHONE;
    }

    /**
     * @param PHONE 设置 PHONE 的值
     */
    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("toString : ");
        ret.append(", UID='" + UID + "'");
        ret.append(", LOGIN_ID='" + LOGIN_ID + "'");
        ret.append(", PWD='" + PWD + "'");
        ret.append(", REG_DATETIME='" + REG_DATETIME + "'");
        ret.append(", LOGINS='" + LOGINS + "'");
        ret.append(", LAST_LOGIN_DATETIME='" + LAST_LOGIN_DATETIME + "'");
        ret.append(", LAST_LOGIN_IP='" + LAST_LOGIN_IP + "'");
        ret.append(", QUESTION='" + QUESTION + "'");
        ret.append(", ANSWER='" + ANSWER + "'");
        ret.append(", STATE='" + STATE + "'");
        ret.append(", EMAIL='" + EMAIL + "'");
        ret.append(", FACE_URL='" + FACE_URL + "'");
        ret.append(", USER_REMARK='" + USER_REMARK + "'");
        ret.append(", REG_VILIDATE_CODE='" + REG_VILIDATE_CODE + "'");
        ret.append(", PHONE='" + PHONE + "'");
        return ret.toString();
    }
}