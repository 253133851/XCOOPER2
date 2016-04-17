package com.xcooper.vo;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 日志类型VO
 * @author zdk
 * 2016-03-28 19:40:50
 */
@DatabaseTable(tableName = "log_type")
public class LogTypeVO {

	//LOG_TYPE_ID
	@DatabaseField
	int LOG_TYPE_ID;


	//TYPE_NAME
	@DatabaseField
	String TYPE_NAME;

	//REMARK
	@DatabaseField
	String REMARK;

	/**
	 * @return 返回 LOG_TYPE_ID LOG_TYPE_ID
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
	 * @return 返回 TYPE_NAME TYPE_NAME
	 */
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	/**
	 * @param TYPE_NAME 设置 TYPE_NAME 的值
	 */
	public void setTYPE_NAME(String TYPE_NAME) {
		this.TYPE_NAME = TYPE_NAME;
	}

	/**
	 * @return 返回 REMARK REMARK
	 */
	public String getREMARK() {
		return REMARK;
	}

	/**
	 * @param REMARK 设置 REMARK 的值
	 */
	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", LOG_TYPE_ID='" + LOG_TYPE_ID + "'");
		ret.append(", TYPE_NAME='" + TYPE_NAME + "'");
		ret.append(", REMARK='" + REMARK + "'");
		return ret.toString();
	}
}