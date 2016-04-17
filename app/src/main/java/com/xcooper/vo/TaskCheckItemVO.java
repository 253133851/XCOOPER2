package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 任务检查项VO
 * @author zdk
 * 2016-03-28 19:38:42
 */
@DatabaseTable(tableName = "task_check_item")
public class TaskCheckItemVO {

	//ID
	@DatabaseField
	int ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//TASK_ID
	@DatabaseField
	int TASK_ID;

	//ITEM_NAME
	@DatabaseField
	String ITEM_NAME;

	//IS_DONE
	@DatabaseField
	int IS_DONE;

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
	 * @return 返回 ITEM_NAME ITEM_NAME
	 */
	public String getITEM_NAME() {
		return ITEM_NAME;
	}

	/**
	 * @param ITEM_NAME 设置 ITEM_NAME 的值
	 */
	public void setITEM_NAME(String ITEM_NAME) {
		this.ITEM_NAME = ITEM_NAME;
	}

	/**
	 * @return 返回 IS_DONE IS_DONE
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

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", ID='" + ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", TASK_ID='" + TASK_ID + "'");
		ret.append(", ITEM_NAME='" + ITEM_NAME + "'");
		ret.append(", IS_DONE='" + IS_DONE + "'");
		return ret.toString();
	}
}