package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 团队_成员VO
 * @author zdk
 * 2016-03-28 19:26:29
 */
@DatabaseTable(tableName = "team_member")
public class TeamMemberVO {

	//ID
	@DatabaseField
	int ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//TEAM_ID
	@DatabaseField
	int TEAM_ID;

	//MEMBER_ID
	@DatabaseField
	int MEMBER_ID;

	//LEVEL
	@DatabaseField
	int LEVEL;

	//ADD_DATETIME
	@DatabaseField
	Timestamp ADD_DATETIME;

	//UPDATE_DATETIME
	@DatabaseField
	Timestamp UPDATE_DATETIME;

	/**
	 * @return 返回 ID ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param ID 设置 ID 的值
	 */
	public void setID(int ID) {
		this.ID = ID;
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
	 * @return 返回 MEMBER_ID MEMBER_ID
	 */
	public int getMEMBER_ID() {
		return MEMBER_ID;
	}

	/**
	 * @param MEMBER_ID 设置 MEMBER_ID 的值
	 */
	public void setMEMBER_ID(int MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}

	/**
	 * @return 返回 LEVEL LEVEL
	 */
	public int getLEVEL() {
		return LEVEL;
	}

	/**
	 * @param LEVEL 设置 LEVEL 的值
	 */
	public void setLEVEL(int LEVEL) {
		this.LEVEL = LEVEL;
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
		ret.append(", ID='" + ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", TEAM_ID='" + TEAM_ID + "'");
		ret.append(", MEMBER_ID='" + MEMBER_ID + "'");
		ret.append(", LEVEL='" + LEVEL + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		return ret.toString();
	}
}