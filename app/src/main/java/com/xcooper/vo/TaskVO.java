package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 任务VO
 * @author zdk
 * 2016-03-28 19:34:51
 */
@DatabaseTable(tableName = "task")
public class TaskVO{

	//TASK_ID
	@DatabaseField
	int TASK_ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//PROJECT_ID
	@DatabaseField
	int PROJECT_ID;

	//LIST_ID
	@DatabaseField
	int LIST_ID;

	//TASK_NAME
	@DatabaseField
	String TASK_NAME;

	//CREATE_ID
	@DatabaseField
	int CREATE_ID;

	//执行人id
	@DatabaseField
	int EXE_ID;

	//END_DATETIME
	@DatabaseField
	Timestamp END_DATETIME;

	//TASK_INFO
	@DatabaseField
	String TASK_INFO;

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
	 * @return 返回 TASK_ID TASK_ID
	 */
	public int getTASK_ID() {
		return TASK_ID;
	}

	/**
	 * @param TASK_ID 设置 TASK_ID 的值
	 */
	public void setTASK_ID(int TASK_ID) {
		this.TASK_ID = TASK_ID;
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
	 * @return 返回 TASK_NAME TASK_NAME
	 */
	public String getTASK_NAME() {
		return TASK_NAME;
	}

	/**
	 * @param TASK_NAME 设置 TASK_NAME 的值
	 */
	public void setTASK_NAME(String TASK_NAME) {
		this.TASK_NAME = TASK_NAME;
	}

	/**
	 * @return 返回 CREATE_ID CREATE_ID
	 */
	public int getCREATE_ID() {
		return CREATE_ID;
	}

	/**
	 * @param CREATE_ID 设置 CREATE_ID 的值
	 */
	public void setCREATE_ID(int CREATE_ID) {
		this.CREATE_ID = CREATE_ID;
	}

	/**
	 * @return 返回 EXE_ID 执行人id
	 */
	public int getEXE_ID() {
		return EXE_ID;
	}

	/**
	 * @param EXE_ID 设置 EXE_ID 的值
	 */
	public void setEXE_ID(int EXE_ID) {
		this.EXE_ID = EXE_ID;
	}

	/**
	 * @return 返回 END_DATETIME END_DATETIME
	 */
	public Timestamp getEND_DATETIME() {
		return END_DATETIME;
	}

	/**
	 * @param END_DATETIME 设置 END_DATETIME 的值
	 */
	public void setEND_DATETIME(Timestamp END_DATETIME) {
		this.END_DATETIME = END_DATETIME;
	}

	/**
	 * @return 返回 TASK_INFO TASK_INFO
	 */
	public String getTASK_INFO() {
		return TASK_INFO;
	}

	/**
	 * @param TASK_INFO 设置 TASK_INFO 的值
	 */
	public void setTASK_INFO(String TASK_INFO) {
		this.TASK_INFO = TASK_INFO;
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
		ret.append(", TASK_ID='" + TASK_ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", PROJECT_ID='" + PROJECT_ID + "'");
		ret.append(", LIST_ID='" + LIST_ID + "'");
		ret.append(", TASK_NAME='" + TASK_NAME + "'");
		ret.append(", CREATE_ID='" + CREATE_ID + "'");
		ret.append(", EXE_ID='" + EXE_ID + "'");
		ret.append(", END_DATETIME='" + END_DATETIME + "'");
		ret.append(", TASK_INFO='" + TASK_INFO + "'");
		ret.append(", IS_DEL='" + IS_DEL + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		ret.append(", DEL_DATETIME='" + DEL_DATETIME + "'");
		return ret.toString();
	}
}