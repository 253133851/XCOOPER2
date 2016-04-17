package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 用户VO
 * @author zdk
 * 2016-03-28 19:24:31
 */
@DatabaseTable(tableName = "member")
public class MemberVO{

	//MEMBER_ID
	@DatabaseField
	int MEMBER_ID;

	//用户ID
	@DatabaseField
	int UID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//姓名
	@DatabaseField
	String NAME;

	//职位
	@DatabaseField
	String JOB;

	//手机
	@DatabaseField
	String MOBILE;

	//邮箱
	@DatabaseField
	String EMAIL;

	//QQ
	@DatabaseField
	String QQ;

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
	 * @return 返回 NAME 姓名
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * @param NAME 设置 NAME 的值
	 */
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	/**
	 * @return 返回 JOB 职位
	 */
	public String getJOB() {
		return JOB;
	}

	/**
	 * @param JOB 设置 JOB 的值
	 */
	public void setJOB(String JOB) {
		this.JOB = JOB;
	}

	/**
	 * @return 返回 MOBILE 手机
	 */
	public String getMOBILE() {
		return MOBILE;
	}

	/**
	 * @param MOBILE 设置 MOBILE 的值
	 */
	public void setMOBILE(String MOBILE) {
		this.MOBILE = MOBILE;
	}

	/**
	 * @return 返回 EMAIL 邮箱
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
	 * @return 返回 QQ QQ
	 */
	public String getQQ() {
		return QQ;
	}

	/**
	 * @param QQ 设置 QQ 的值
	 */
	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", MEMBER_ID='" + MEMBER_ID + "'");
		ret.append(", UID='" + UID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", NAME='" + NAME + "'");
		ret.append(", JOB='" + JOB + "'");
		ret.append(", MOBILE='" + MOBILE + "'");
		ret.append(", EMAIL='" + EMAIL + "'");
		ret.append(", QQ='" + QQ + "'");
		return ret.toString();
	}
}