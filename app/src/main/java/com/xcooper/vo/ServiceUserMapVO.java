package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 服务VO
 * @author zdk
 * 2016-03-28 19:23:04
 */
@DatabaseTable(tableName = "service_user_map")
public class ServiceUserMapVO{

	//服务ID
	@DatabaseField
	int SERVICE_ID;

	//UID
	@DatabaseField
	int UID;


	public int getSERVICE_ID() {
		return SERVICE_ID;
	}

	public void setSERVICE_ID(int SERVICE_ID) {
		this.SERVICE_ID = SERVICE_ID;
	}

	/**
	 * @return 返回 UID UID
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

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", SERVICE_ID='" + SERVICE_ID + "'");
		ret.append(", UID='" + UID + "'");
		return ret.toString();
	}
}