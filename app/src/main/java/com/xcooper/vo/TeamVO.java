package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 团队VO
 * @author zdk
 * 2016-03-28 19:25:36
 */
@DatabaseTable(tableName = "team")
public class TeamVO {

	//TEAM_ID
	@DatabaseField
	int TEAM_ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//创建人
	@DatabaseField
	int CREATE_ID;

	//TEAM_NAME
	@DatabaseField
	String TEAM_NAME;

	//IS_DEL
	@DatabaseField
	int IS_DEL;

	//ADD_DATETIME
	@DatabaseField
	Timestamp ADD_DATETIME;

	//UPDATE_DATETIME
	@DatabaseField
	Timestamp UPDATE_DATETIME;

	/**
	 * @return 返回 TEAM_ID TEAM_ID
	 */
	public int getTEAM_ID() {
		return TEAM_ID;
	}

	/**
	 * @param TEAM_ID 设置 TEAM_ID 的值
	 */
	public void setTEAM_ID(int TEAM_ID) {
		this.TEAM_ID = TEAM_ID;
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

	public int getCREATE_ID() {
		return CREATE_ID;
	}

	public void setCREATE_ID(int CREATE_ID) {
		this.CREATE_ID = CREATE_ID;
	}

	/**
	 * @return 返回 TEAM_NAME TEAM_NAME
	 */
	public String getTEAM_NAME() {
		return TEAM_NAME;
	}

	/**
	 * @param TEAM_NAME 设置 TEAM_NAME 的值
	 */
	public void setTEAM_NAME(String TEAM_NAME) {
		this.TEAM_NAME = TEAM_NAME;
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

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", TEAM_ID='" + TEAM_ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", CREATE_ID='" + CREATE_ID + "'");
		ret.append(", TEAM_NAME='" + TEAM_NAME + "'");
		ret.append(", IS_DEL='" + IS_DEL + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		return ret.toString();
	}
}