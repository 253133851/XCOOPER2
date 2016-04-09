package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

@DatabaseTable(tableName = "cleanordergoods")
public class CleanOrderDetailVO {

    public static final int STATE_DAIYUYUE = 0;
    public static final int STATE_DAISHANGMEN = 1;
    public static final int STATE_ZHENGZAISHANGMEN = 2;
    public static final int STATE_KAISHIQINGXI = 3;
    public static final int STATE_YIWANCHENG = 4;


    public static final int CONFIRM_YES = 1;
    public static final int CONFIRM_NO = 0;

    @DatabaseField
    private int ID;
    @DatabaseField
    private int CLEAN_ORDER_ID;
    @DatabaseField
    private int PRD_ID;
    @DatabaseField
    private int SKU_ID;
    @DatabaseField
    private String PRICE;
    @DatabaseField
    private String GOHOME_DATE;
    @DatabaseField
    private String GOHOME_TIME;
    @DatabaseField
    private String BEGIN_GOHOME_DATETIME;
    @DatabaseField
    private String END_GOHOME_DATETIME;
    @DatabaseField
    private int STATE;
    @DatabaseField
    private String PRD_NAME;
    @DatabaseField
    private String IMAGE_URL;
    @DatabaseField
    private int HAS_CONFIRM;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCLEAN_ORDER_ID() {
        return CLEAN_ORDER_ID;
    }

    public void setCLEAN_ORDER_ID(int CLEAN_ORDER_ID) {
        this.CLEAN_ORDER_ID = CLEAN_ORDER_ID;
    }

    public int getPRD_ID() {
        return PRD_ID;
    }

    public void setPRD_ID(int PRD_ID) {
        this.PRD_ID = PRD_ID;
    }

    public int getSKU_ID() {
        return SKU_ID;
    }

    public void setSKU_ID(int SKU_ID) {
        this.SKU_ID = SKU_ID;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getGOHOME_DATE() {
        return GOHOME_DATE;
    }

    public void setGOHOME_DATE(String GOHOME_DATE) {
        this.GOHOME_DATE = GOHOME_DATE;
    }

    public String getGOHOME_TIME() {
        return GOHOME_TIME;
    }

    public void setGOHOME_TIME(String GOHOME_TIME) {
        this.GOHOME_TIME = GOHOME_TIME;
    }

    public String getBEGIN_GOHOME_DATETIME() {
        return BEGIN_GOHOME_DATETIME;
    }

    public void setBEGIN_GOHOME_DATETIME(String BEGIN_GOHOME_DATETIME) {
        this.BEGIN_GOHOME_DATETIME = BEGIN_GOHOME_DATETIME;
    }

    public String getEND_GOHOME_DATETIME() {
        return END_GOHOME_DATETIME;
    }

    public void setEND_GOHOME_DATETIME(String END_GOHOME_DATETIME) {
        this.END_GOHOME_DATETIME = END_GOHOME_DATETIME;
    }

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    public String getPRD_NAME() {
        return PRD_NAME;
    }

    public void setPRD_NAME(String PRD_NAME) {
        this.PRD_NAME = PRD_NAME;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    public void setIMAGE_URL(String IMAGE_URL) {
        this.IMAGE_URL = IMAGE_URL;
    }

    public int getHAS_CONFIRM() {
        return HAS_CONFIRM;
    }

    public void setHAS_CONFIRM(int HAS_CONFIRM) {
        this.HAS_CONFIRM = HAS_CONFIRM;
    }
}
