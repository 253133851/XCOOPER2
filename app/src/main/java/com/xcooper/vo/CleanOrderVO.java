package com.xcooper.vo;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cleanorderinfo")
public class CleanOrderVO {

    public static final int STATE_WEIWANCHENG = 0;
    public static final int STATE_YIWANCHENG = 1;

    public static final int PAY_STATE_FAIL = 0;
    public static final int PAY_STATE_SUCCESS = 1;

    @DatabaseField
    int ID;
    @DatabaseField
    int CLEAN_MEMBER_ID;
    @DatabaseField
    int GRADE_STAR;
    @DatabaseField
    int STATE;
    @DatabaseField
    String PHONE;
    @DatabaseField
    String GRADE_CONTENT;
    @DatabaseField
    String ADD_DATETIME;
    @DatabaseField
    String END_DATETIME;
    @DatabaseField
    String GRADE_DATETIME;
    @DatabaseField
    String PAY_DATETIME;
    @DatabaseField
    String RETURN_DATETIME;
    @DatabaseField
    String OVER_PRICE;
    @DatabaseField
    String PAY_TYPE;
    @DatabaseField
    String ACCOUNT_PAY;
    @DatabaseField
    String WX_PAY;
    @DatabaseField
    String DISCOUNT_CODE;
    @DatabaseField
    String SUM_PRICE;
    @DatabaseField
    String REMARK;
    @DatabaseField
    String ORDER_ADDR;
    @DatabaseField
    String BACK;
    @DatabaseField
    String CUSTOMER_DISCOUNT;
    @DatabaseField
    String CUSTOMER_DISCOUNT_REASON;
    @DatabaseField
    String WX_PAY_CALLBACK_ID;
    @DatabaseField
    String DISCOUNT_CODE_MONEY;
    @DatabaseField
    int PAY_SUCCESS;

    public int getPAY_SUCCESS() {
        return PAY_SUCCESS;
    }

    public void setPAY_SUCCESS(int PAY_SUCCESS) {
        this.PAY_SUCCESS = PAY_SUCCESS;
    }

    public String getDISCOUNT_CODE_MONEY() {
        return DISCOUNT_CODE_MONEY;
    }

    public void setDISCOUNT_CODE_MONEY(String DISCOUNT_CODE_MONEY) {
        this.DISCOUNT_CODE_MONEY = DISCOUNT_CODE_MONEY;
    }

    public String getSUM_PRICE() {
        return SUM_PRICE;
    }

    public void setSUM_PRICE(String SUM_PRICE) {
        this.SUM_PRICE = SUM_PRICE;
    }

    public String getWX_PAY_CALLBACK_ID() {
        return WX_PAY_CALLBACK_ID;
    }

    public void setWX_PAY_CALLBACK_ID(String WX_PAY_CALLBACK_ID) {
        this.WX_PAY_CALLBACK_ID = WX_PAY_CALLBACK_ID;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCLEAN_MEMBER_ID() {
        return CLEAN_MEMBER_ID;
    }

    public void setCLEAN_MEMBER_ID(int CLEAN_MEMBER_ID) {
        this.CLEAN_MEMBER_ID = CLEAN_MEMBER_ID;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public int getGRADE_STAR() {
        return GRADE_STAR;
    }

    public void setGRADE_STAR(int GRADE_STAR) {
        this.GRADE_STAR = GRADE_STAR;
    }

    public String getGRADE_CONTENT() {
        return GRADE_CONTENT;
    }

    public void setGRADE_CONTENT(String GRADE_CONTENT) {
        this.GRADE_CONTENT = GRADE_CONTENT;
    }

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }


    public String getOVER_PRICE() {
        return OVER_PRICE;
    }

    public void setOVER_PRICE(String OVER_PRICE) {
        this.OVER_PRICE = OVER_PRICE;
    }

    public String getPAY_TYPE() {
        return PAY_TYPE;
    }

    public void setPAY_TYPE(String PAY_TYPE) {
        this.PAY_TYPE = PAY_TYPE;
    }

    public String getACCOUNT_PAY() {
        return ACCOUNT_PAY;
    }

    public void setACCOUNT_PAY(String ACCOUNT_PAY) {
        this.ACCOUNT_PAY = ACCOUNT_PAY;
    }

    public String getWX_PAY() {
        return WX_PAY;
    }

    public void setWX_PAY(String WX_PAY) {
        this.WX_PAY = WX_PAY;
    }

    public String getDISCOUNT_CODE() {
        return DISCOUNT_CODE;
    }

    public void setDISCOUNT_CODE(String DISCOUNT_CODE) {
        this.DISCOUNT_CODE = DISCOUNT_CODE;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getORDER_ADDR() {
        return ORDER_ADDR;
    }

    public void setORDER_ADDR(String ORDER_ADDR) {
        this.ORDER_ADDR = ORDER_ADDR;
    }

    public String getBACK() {
        return BACK;
    }

    public void setBACK(String BACK) {
        this.BACK = BACK;
    }


    public String getCUSTOMER_DISCOUNT() {
        return CUSTOMER_DISCOUNT;
    }

    public void setCUSTOMER_DISCOUNT(String CUSTOMER_DISCOUNT) {
        this.CUSTOMER_DISCOUNT = CUSTOMER_DISCOUNT;
    }

    public String getCUSTOMER_DISCOUNT_REASON() {
        return CUSTOMER_DISCOUNT_REASON;
    }

    public void setCUSTOMER_DISCOUNT_REASON(String CUSTOMER_DISCOUNT_REASON) {
        this.CUSTOMER_DISCOUNT_REASON = CUSTOMER_DISCOUNT_REASON;
    }

    public String getADD_DATETIME() {
        return ADD_DATETIME;
    }

    public void setADD_DATETIME(String ADD_DATETIME) {
        this.ADD_DATETIME = ADD_DATETIME;
    }

    public String getEND_DATETIME() {
        return END_DATETIME;
    }

    public void setEND_DATETIME(String END_DATETIME) {
        this.END_DATETIME = END_DATETIME;
    }

    public String getGRADE_DATETIME() {
        return GRADE_DATETIME;
    }

    public void setGRADE_DATETIME(String GRADE_DATETIME) {
        this.GRADE_DATETIME = GRADE_DATETIME;
    }

    public String getPAY_DATETIME() {
        return PAY_DATETIME;
    }

    public void setPAY_DATETIME(String PAY_DATETIME) {
        this.PAY_DATETIME = PAY_DATETIME;
    }

    public String getRETURN_DATETIME() {
        return RETURN_DATETIME;
    }

    public void setRETURN_DATETIME(String RETURN_DATETIME) {
        this.RETURN_DATETIME = RETURN_DATETIME;
    }
}
