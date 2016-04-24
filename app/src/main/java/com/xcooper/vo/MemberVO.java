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
	int member_ID;

	//用户ID
	@DatabaseField
	int uid;

	//SERVICE_ID
	@DatabaseField
	int service_ID;

	//姓名
	@DatabaseField
	String name;

	//职位
	@DatabaseField
	String job;

	//手机
	@DatabaseField
	String mobile;

	//邮箱
	@DatabaseField
	String email;

	//QQ
	@DatabaseField
	String qq;

	public int getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(int member_ID) {
		this.member_ID = member_ID;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getService_ID() {
		return service_ID;
	}

	public void setService_ID(int service_ID) {
		this.service_ID = service_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("toString : ");
		ret.append(", MEMBER_ID='" + member_ID + "'");
		ret.append(", UID='" + uid + "'");
		ret.append(", SERVICE_ID='" + service_ID + "'");
		ret.append(", NAME='" + name + "'");
		ret.append(", JOB='" + job + "'");
		ret.append(", MOBILE='" + mobile + "'");
		ret.append(", EMAIL='" + email + "'");
		ret.append(", QQ='" + qq + "'");
		return ret.toString();
	}
}