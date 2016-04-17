package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 讨论VO
 * @author zdk
 * 2016-03-28 19:33:56
 */
@DatabaseTable(tableName = "comment")
public class CommentVO  {

	@DatabaseField
	int COMMENT_ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//评论人
	@DatabaseField
	int COMMENT_MEMBER_ID;

	//COMMENT_TITLE
	@DatabaseField
	String COMMENT_TITLE;

	//评论内容
	@DatabaseField
	String COMMENT;

	//TYPE
	@DatabaseField
	int TYPE;

	//通知目标
	@DatabaseField
	String TARGET_ID;

	//访客是否可见
	@DatabaseField
	int IS_SHOW;

	//是否结束
	@DatabaseField
	int IS_DONE;

	//排序值
	@DatabaseField
	int ORDER_NUM;

	//ADD_DATETIME
	@DatabaseField
	Timestamp ADD_DATETIME;

	//UPDATE_DATETIME
	@DatabaseField
	Timestamp UPDATE_DATETIME;

	//END_DATETIME
	@DatabaseField
	Timestamp END_DATETIME;

	String ss;

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	/**
	 * @return 返回 COMMENT_ID COMMENT_ID
	 */
	public int getCOMMENT_ID() {
		return COMMENT_ID;
	}

	/**
	 * @param COMMENT_ID 设置 COMMENT_ID 的值
	 */
	public void setCOMMENT_ID(int COMMENT_ID) {
		this.COMMENT_ID = COMMENT_ID;
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
	 * @return 返回 COMMENT_MEMBER_ID 评论人
	 */
	public int getCOMMENT_MEMBER_ID() {
		return COMMENT_MEMBER_ID;
	}

	/**
	 * @param COMMENT_MEMBER_ID 设置 COMMENT_MEMBER_ID 的值
	 */
	public void setCOMMENT_MEMBER_ID(int COMMENT_MEMBER_ID) {
		this.COMMENT_MEMBER_ID = COMMENT_MEMBER_ID;
	}

	/**
	 * @return 返回 COMMENT_TITLE COMMENT_TITLE
	 */
	public String getCOMMENT_TITLE() {
		return COMMENT_TITLE;
	}

	/**
	 * @param COMMENT_TITLE 设置 COMMENT_TITLE 的值
	 */
	public void setCOMMENT_TITLE(String COMMENT_TITLE) {
		this.COMMENT_TITLE = COMMENT_TITLE;
	}

	/**
	 * @return 返回 COMMENT 评论内容
	 */
	public String getCOMMENT() {
		return COMMENT;
	}

	/**
	 * @param COMMENT 设置 COMMENT 的值
	 */
	public void setCOMMENT(String COMMENT) {
		this.COMMENT = COMMENT;
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
	 * @return 返回 TARGET_ID 通知目标
	 */
	public String getTARGET_ID() {
		return TARGET_ID;
	}

	/**
	 * @param TARGET_ID 设置 TARGET_ID 的值
	 */
	public void setTARGET_ID(String TARGET_ID) {
		this.TARGET_ID = TARGET_ID;
	}

	/**
	 * @return 返回 IS_SHOW 访客是否可见
	 */
	public int getIS_SHOW() {
		return IS_SHOW;
	}

	/**
	 * @param IS_SHOW 设置 IS_SHOW 的值
	 */
	public void setIS_SHOW(int IS_SHOW) {
		this.IS_SHOW = IS_SHOW;
	}

	/**
	 * @return 返回 IS_DONE 是否结束
	 */
	public int getIS_DONE() {
		return IS_DONE;
	}

	/**
	 * @param IS_DONE 设置 IS_DONE 的值
	 */
	public void setIS_DONE(int IS_DONE) {
		this.IS_DONE = IS_DONE;
	}

	/**
	 * @return 返回 ORDER_NUM 排序值
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

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", COMMENT_ID='" + COMMENT_ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", COMMENT_MEMBER_ID='" + COMMENT_MEMBER_ID + "'");
		ret.append(", COMMENT_TITLE='" + COMMENT_TITLE + "'");
		ret.append(", COMMENT='" + COMMENT + "'");
		ret.append(", TYPE='" + TYPE + "'");
		ret.append(", TARGET_ID='" + TARGET_ID + "'");
		ret.append(", IS_SHOW='" + IS_SHOW + "'");
		ret.append(", IS_DONE='" + IS_DONE + "'");
		ret.append(", ORDER_NUM='" + ORDER_NUM + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		ret.append(", END_DATETIME='" + END_DATETIME + "'");
		return ret.toString();
	}
}