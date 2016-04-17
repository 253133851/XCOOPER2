package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 项目清单VO
 * @author zdk
 * 2016-03-28 19:33:03
 */
@DatabaseTable(tableName = "list")
public class ListVO {

	//LIST_ID
	@DatabaseField
	int LIST_ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//LIST_NAME
	@DatabaseField
	String LIST_NAME;

	//ORDER_NUM|
	@DatabaseField
	int ORDER_NUM;

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
	 * @return 返回 LIST_ID LIST_ID
	 */
	public int getLIST_ID() {
		return LIST_ID;
	}

	/**
	 * @param LIST_ID 设置 LIST_ID 的值
	 */
	public void setLIST_ID(int LIST_ID) {
		this.LIST_ID = LIST_ID;
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
	 * @return 返回 LIST_NAME LIST_NAME
	 */
	public String getLIST_NAME() {
		return LIST_NAME;
	}

	/**
	 * @param LIST_NAME 设置 LIST_NAME 的值
	 */
	public void setLIST_NAME(String LIST_NAME) {
		this.LIST_NAME = LIST_NAME;
	}

	/**
	 * @return 返回 ORDER_NUM ORDER_NUM
	 */
	public int getORDER_NUM() {
		return ORDER_NUM;
	}

	/**
	 * @param ORDER_NUM 设置 ORDER_NUM 的值
	 */
	public void setORDER_NUM(int ORDER_NUM) {
		this.ORDER_NUM = ORDER_NUM;
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
		ret.append(", LIST_ID='" + LIST_ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", LIST_NAME='" + LIST_NAME + "'");
		ret.append(", ORDER_NUM='" + ORDER_NUM + "'");
		ret.append(", IS_DEL='" + IS_DEL + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		ret.append(", DEL_DATETIME='" + DEL_DATETIME + "'");
		return ret.toString();
	}
}