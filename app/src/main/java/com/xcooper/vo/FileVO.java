package com.xcooper.vo;



import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 项目文档VO
 * @author zdk
 * 2016-03-28 19:31:58
 */
@DatabaseTable(tableName = "file")
public class FileVO {

	//ID
	@DatabaseField
	int ID;

	//SERVICE_ID
	@DatabaseField
	int SERVICE_ID;

	//PROJECT_ID
	@DatabaseField
	int PROJECT_ID;

	//类型
	@DatabaseField
	int TYPE;

	//FILE_NAME
	@DatabaseField
	String FILE_NAME;

	//后缀
	@DatabaseField
	String FILE_TYPE;

	//FILE_SIZE
	@DatabaseField
	String FILE_SIZE;

	//父分类
	@DatabaseField
	String PARENT_CLASS_ID;

	//分类路径
	@DatabaseField
	String CLASS_PATH;

	//URL
	@DatabaseField
	String URL;

	//CREATE_ID
	@DatabaseField
	int CREATE_ID;

	//ADD_DATETIME
	@DatabaseField
	Timestamp ADD_DATETIME;

	//UPDATE_DATETIME
	@DatabaseField
	Timestamp UPDATE_DATETIME;

	//下载次数
	@DatabaseField
	int DOWN_NUM;

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
	 * @return 返回 TYPE 类型
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
	 * @return 返回 FILE_NAME FILE_NAME
	 */
	public String getFILE_NAME() {
		return FILE_NAME;
	}

	/**
	 * @param FILE_NAME 设置 FILE_NAME 的值
	 */
	public void setFILE_NAME(String FILE_NAME) {
		this.FILE_NAME = FILE_NAME;
	}

	/**
	 * @return 返回 FILE_TYPE 后缀
	 */
	public String getFILE_TYPE() {
		return FILE_TYPE;
	}

	/**
	 * @param FILE_TYPE 设置 FILE_TYPE 的值
	 */
	public void setFILE_TYPE(String FILE_TYPE) {
		this.FILE_TYPE = FILE_TYPE;
	}

	/**
	 * @return 返回 FILE_SIZE FILE_SIZE
	 */
	public String getFILE_SIZE() {
		return FILE_SIZE;
	}

	/**
	 * @param FILE_SIZE 设置 FILE_SIZE 的值
	 */
	public void setFILE_SIZE(String FILE_SIZE) {
		this.FILE_SIZE = FILE_SIZE;
	}

	/**
	 * @return 返回 PARENT_CLASS_ID 父分类
	 */
	public String getPARENT_CLASS_ID() {
		return PARENT_CLASS_ID;
	}

	/**
	 * @param PARENT_CLASS_ID 设置 PARENT_CLASS_ID 的值
	 */
	public void setPARENT_CLASS_ID(String PARENT_CLASS_ID) {
		this.PARENT_CLASS_ID = PARENT_CLASS_ID;
	}

	/**
	 * @return 返回 CLASS_PATH 分类路径
	 */
	public String getCLASS_PATH() {
		return CLASS_PATH;
	}

	/**
	 * @param CLASS_PATH 设置 CLASS_PATH 的值
	 */
	public void setCLASS_PATH(String CLASS_PATH) {
		this.CLASS_PATH = CLASS_PATH;
	}

	/**
	 * @return 返回 URL URL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param URL 设置 URL 的值
	 */
	public void setURL(String URL) {
		this.URL = URL;
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
	 * @return 返回 DOWN_NUM 下载次数
	 */
	public int getDOWN_NUM() {
		return DOWN_NUM;
	}

	/**
	 * @param DOWN_NUM 设置 DOWN_NUM 的值
	 */
	public void setDOWN_NUM(int DOWN_NUM) {
		this.DOWN_NUM = DOWN_NUM;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", ID='" + ID + "'");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", PROJECT_ID='" + PROJECT_ID + "'");
		ret.append(", TYPE='" + TYPE + "'");
		ret.append(", FILE_NAME='" + FILE_NAME + "'");
		ret.append(", FILE_TYPE='" + FILE_TYPE + "'");
		ret.append(", FILE_SIZE='" + FILE_SIZE + "'");
		ret.append(", PARENT_CLASS_ID='" + PARENT_CLASS_ID + "'");
		ret.append(", CLASS_PATH='" + CLASS_PATH + "'");
		ret.append(", URL='" + URL + "'");
		ret.append(", CREATE_ID='" + CREATE_ID + "'");
		ret.append(", ADD_DATETIME='" + ADD_DATETIME + "'");
		ret.append(", UPDATE_DATETIME='" + UPDATE_DATETIME + "'");
		ret.append(", DOWN_NUM='" + DOWN_NUM + "'");
		return ret.toString();
	}
}