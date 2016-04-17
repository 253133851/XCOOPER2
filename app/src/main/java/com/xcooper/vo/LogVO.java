package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 日志VO
 * @author zdk
 * 2016-03-28 19:40:04
 */
@DatabaseTable(tableName = "log")
public class LogVO {

	//LOG_ID
	@DatabaseField
	int LOG_ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//操作人
	@DatabaseField
	int OPERA_ID;

	//操作类型
	@DatabaseField
	int LOG_TYPE_ID;

	//操作目标id
	@DatabaseField
	int TARGET_ID;

	//操作目标
	@DatabaseField
	String TARGET;

	//操作内容
	@DatabaseField
	String OPERA;

	//REMARK1
	@DatabaseField
	String REMARK1;

	//REMARK2
	@DatabaseField
	String REMARK2;

	//REMARK3
	@DatabaseField
	String REMARK3;

	//ADD_DATETIME
	@DatabaseField
	Timestamp ADD_DATETIME;

	/**
	 * @return 返回 LOG_ID LOG_ID
	 */
	public int getLOG_ID() {
		return LOG_ID;
	}

	/**
	 * @param LOG_ID 设置 LOG_ID 的值
	 */
	public void setLOG_ID(int LOG_ID) {
		this.LOG_ID = LOG_ID;
	}

	/**
	 * @return 返回 SERVICE_ID SERVICE_ID
	 */
	public int getSERVICE_ID() {
		return SERVICE_ID;
	}

	/**
	 * @param SERVICE_ID 设置 SERVICE_ID 的值
	 */
	public void setSERVICE_ID(int SERVICE_ID) {
		this.SERVICE_ID = SERVICE_ID;
	}

	/**
	 * @return 返回 OPERA_ID 操作人
	 */
	public int getOPERA_ID() {
		return OPERA_ID;
	}

	/**
	 * @param OPERA_ID 设置 OPERA_ID 的值
	 */
	public void setOPERA_ID(int OPERA_ID) {
		this.OPERA_ID = OPERA_ID;
	}

	/**
	 * @return 返回 LOG_TYPE_ID 操作类型
	 */
	public int getLOG_TYPE_ID() {
		return LOG_TYPE_ID;
	}

	/**
	 * @param LOG_TYPE_ID 设置 LOG_TYPE_ID 的值
	 */
	public void setLOG_TYPE_ID(int LOG_TYPE_ID) {
		this.LOG_TYPE_ID = LOG_TYPE_ID;
	}

	/**
	 * @return 返回 TARGET_ID 操作目标id
	 */
	public int getTARGET_ID() {
		return TARGET_ID;
	}

	/**
	 * @param TARGET_ID 设置 TARGET_ID 的值
	 */
	public void setTARGET_ID(int TARGET_ID) {
		this.TARGET_ID = TARGET_ID;
	}

	/**
	 * @return 返回 TARGET 操作目标
	 */
	public String getTARGET() {
		return TARGET;
	}

	/**
	 * @param TARGET 设置 TARGET 的值
	 */
	public void setTARGET(String TARGET) {
		this.TARGET = TARGET;
	}

	/**
	 * @return 返回 OPERA 操作内容
	 */
	public String getOPERA() {
		return OPERA;
	}

	/**
	 * @param OPERA 设置 OPERA 的值
	 */
	public void setOPERA(String OPERA) {
		this.OPERA = OPERA;
	}

	/**
	 * @return 返回 REMARK1 REMARK1
	 */
	public String getREMARK1() {
		return REMARK1;
	}

	/**
	 * @param REMARK1 设置 REMARK1 的值
	 */
	public void setREMARK1(String REMARK1) {
		this.REMARK1 = REMARK1;
	}

	/**
	 * @return 返回 REMARK2 REMARK2
	 */
	public String getREMARK2() {
		return REMARK2;
	}

	/**
	 * @param REMARK2 设置 REMARK2 的值
	 */
	public void setREMARK2(String REMARK2) {
		this.REMARK2 = REMARK2;
	}

	/**
	 * @return 返回 REMARK3 REMARK3
	 */
	public String getREMARK3() {
		return REMARK3;
	}

	/**
	 * @param REMARK3 设置 REMARK3 的值
	 */
	public void setREMARK3(String REMARK3) {
		this.REMARK3 = REMARK3;
	}

	/**
	 * @return 返回 ADD_DATETIME ADD_DATETIME
	 */
	public Timestamp getADD_DATETIME() {
		return ADD_DATETIME;
	}

	/**
	 * @param ADD_DATETIME 设置 ADD_DATETIME 的值
	 */
	public void setADD_DATETIME(Timestamp ADD_DATETIME) {
		this.ADD_DATETIME = ADD_DATETIME;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", LOG_ID='" + LOG_ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", OPERA_ID='" + OPERA_ID + "'");
		ret.append(", LOG_TYPE_ID='" + LOG_TYPE_ID + "'");
		ret.append(", TARGET_ID='" + TARGET_ID + "'");
		ret.append(", TARGET='" + TARGET + "'");
		ret.append(", OPERA='" + OPERA + "'");
		ret.append(", REMARK1='" + REMARK1 + "'");
		ret.append(", REMARK2='" + REMARK2 + "'");
		ret.append(", REMARK3='" + REMARK3 + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		return ret.toString();
	}
}