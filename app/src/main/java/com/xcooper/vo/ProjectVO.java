package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 项目VO
 * @author zdk
 * 2016-03-28 19:28:58
 */
@DatabaseTable(tableName = "project")
public class ProjectVO {

	//PROJECT_ID
	@DatabaseField
	int PROJECT_ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//PROJECT_NAME
	@DatabaseField
	String PROJECT_NAME;

	//PROJECT_INFO
	@DatabaseField
	String PROJECT_INFO;

	//TYPE
	@DatabaseField
	int TYPE;

	//是否隐藏敏感
	@DatabaseField
	int IS_HIDE;

	//是否只读
	@DatabaseField
	int IS_READ_ONLY;

	//IS_DEL
	@DatabaseField
	int IS_DEL;

	//ADD_DATETIME
	@DatabaseField
	Timestamp ADD_DATETIME;

	//UPDATE_DATETIME
	@DatabaseField
	Timestamp UPDATE_DATETIME;

	//DEL_DATETIME
	@DatabaseField
	Timestamp DEL_DATETIME;

	/**
	 * @return 返回 PROJECT_ID PROJECT_ID
	 */
	public int getPROJECT_ID() {
		return PROJECT_ID;
	}

	/**
	 * @param PROJECT_ID 设置 PROJECT_ID 的值
	 */
	public void setPROJECT_ID(int PROJECT_ID) {
		this.PROJECT_ID = PROJECT_ID;
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
	 * @return 返回 PROJECT_NAME PROJECT_NAME
	 */
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}

	/**
	 * @param PROJECT_NAME 设置 PROJECT_NAME 的值
	 */
	public void setPROJECT_NAME(String PROJECT_NAME) {
		this.PROJECT_NAME = PROJECT_NAME;
	}

	/**
	 * @return 返回 PROJECT_INFO PROJECT_INFO
	 */
	public String getPROJECT_INFO() {
		return PROJECT_INFO;
	}

	/**
	 * @param PROJECT_INFO 设置 PROJECT_INFO 的值
	 */
	public void setPROJECT_INFO(String PROJECT_INFO) {
		this.PROJECT_INFO = PROJECT_INFO;
	}

	/**
	 * @return 返回 TYPE TYPE
	 */
	public int getTYPE() {
		return TYPE;
	}

	/**
	 * @param TYPE 设置 TYPE 的值
	 */
	public void setTYPE(int TYPE) {
		this.TYPE = TYPE;
	}

	/**
	 * @return 返回 IS_HIDE 是否隐藏敏感
	 */
	public int getIS_HIDE() {
		return IS_HIDE;
	}

	/**
	 * @param IS_HIDE 设置 IS_HIDE 的值
	 */
	public void setIS_HIDE(int IS_HIDE) {
		this.IS_HIDE = IS_HIDE;
	}

	/**
	 * @return 返回 IS_READ_ONLY 是否只读
	 */
	public int getIS_READ_ONLY() {
		return IS_READ_ONLY;
	}

	/**
	 * @param IS_READ_ONLY 设置 IS_READ_ONLY 的值
	 */
	public void setIS_READ_ONLY(int IS_READ_ONLY) {
		this.IS_READ_ONLY = IS_READ_ONLY;
	}

	/**
	 * @return 返回 IS_DEL IS_DEL
	 */
	public int getIS_DEL() {
		return IS_DEL;
	}

	/**
	 * @param IS_DEL 设置 IS_DEL 的值
	 */
	public void setIS_DEL(int IS_DEL) {
		this.IS_DEL = IS_DEL;
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

	/**
	 * @return 返回 UPDATE_DATETIME UPDATE_DATETIME
	 */
	public Timestamp getUPDATE_DATETIME() {
		return UPDATE_DATETIME;
	}

	/**
	 * @param UPDATE_DATETIME 设置 UPDATE_DATETIME 的值
	 */
	public void setUPDATE_DATETIME(Timestamp UPDATE_DATETIME) {
		this.UPDATE_DATETIME = UPDATE_DATETIME;
	}

	/**
	 * @return 返回 DEL_DATETIME DEL_DATETIME
	 */
	public Timestamp getDEL_DATETIME() {
		return DEL_DATETIME;
	}

	/**
	 * @param DEL_DATETIME 设置 DEL_DATETIME 的值
	 */
	public void setDEL_DATETIME(Timestamp DEL_DATETIME) {
		this.DEL_DATETIME = DEL_DATETIME;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", PROJECT_ID='" + PROJECT_ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", PROJECT_NAME='" + PROJECT_NAME + "'");
		ret.append(", PROJECT_INFO='" + PROJECT_INFO + "'");
		ret.append(", TYPE='" + TYPE + "'");
		ret.append(", IS_HIDE='" + IS_HIDE + "'");
		ret.append(", IS_READ_ONLY='" + IS_READ_ONLY + "'");
		ret.append(", IS_DEL='" + IS_DEL + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		ret.append(", DEL_DATETIME='" + DEL_DATETIME + "'");
		return ret.toString();
	}
}