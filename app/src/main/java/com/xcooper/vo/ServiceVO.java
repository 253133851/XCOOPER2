package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 服务VO
 * @author zdk
 * 2016-03-28 19:22:33
 */
@DatabaseTable(tableName = "service")
public class ServiceVO {

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//TEAM_ID
	@DatabaseField
	int TEAM_ID;

	//状态
	@DatabaseField
	int STATE;

	//注册时间
	@DatabaseField
	Timestamp REG_DATETIME;

	//是否为默认服务
	@DatabaseField
	int IS_DEFAULT;

	//创建人 UID ADD_UID
	@DatabaseField
	int ADD_UID;

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
	 * @return 返回 STATE 状态
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
	 * @return 返回 REG_DATETIME 注册时间
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
	 * @return 返回 IS_DEFAULT 是否为默认服务
	 */
	public int getIS_DEFAULT() {
		return IS_DEFAULT;
	}

	/**
	 * @param IS_DEFAULT 设置 IS_DEFAULT 的值
	 */
	public void setIS_DEFAULT(int IS_DEFAULT) {
		this.IS_DEFAULT = IS_DEFAULT;
	}

	/**
	 * @return 返回 ADD_UID 创建人 UID ADD_UID
	 */
	public int getADD_UID() {
		return ADD_UID;
	}

	/**
	 * @param ADD_UID 设置 ADD_UID 的值
	 */
	public void setADD_UID(int ADD_UID) {
		this.ADD_UID = ADD_UID;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", TEAM_ID='" + TEAM_ID + "'");
		ret.append(", STATE='" + STATE + "'");
		ret.append(", REG_DATETIME='" + REG_DATETIME + "'");
		ret.append(", IS_DEFAULT='" + IS_DEFAULT + "'");
		ret.append(", ADD_UID='" + ADD_UID + "'");
		return ret.toString();
	}
}