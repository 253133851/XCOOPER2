package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 项目VO
 *
 * @author zdk
 *         2016-03-28 19:28:58
 */
@DatabaseTable(tableName = "project")
public class ProjectVO {

    //project_ID
    @DatabaseField
    public int project_ID;

    //service_ID
    @DatabaseField
    public int service_ID;

    //project_NAME
    @DatabaseField
    public String project_NAME;

    //project_INFO
    @DatabaseField
    public String project_INFO;

    //type
    @DatabaseField
    public int type;

    //是否隐藏敏感
    @DatabaseField
    public int is_HIDE;

    //是否只读
    @DatabaseField
    public int is_READ_ONLY;

    //is_DEL
    @DatabaseField
    public int is_DEL;

    //add_DATETIME
    @DatabaseField
    public String add_DATETIME;

    //update_DATETIME
    @DatabaseField
    public String update_DATETIME;

    //del_DATETIME
    @DatabaseField
    public String del_DATETIME;

    public int getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    public int getService_ID() {
        return service_ID;
    }

    public void setService_ID(int service_ID) {
        this.service_ID = service_ID;
    }

    public String getProject_NAME() {
        return project_NAME;
    }

    public void setProject_NAME(String project_NAME) {
        this.project_NAME = project_NAME;
    }

    public String getProject_INFO() {
        return project_INFO;
    }

    public void setProject_INFO(String project_INFO) {
        this.project_INFO = project_INFO;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIs_HIDE() {
        return is_HIDE;
    }

    public void setIs_HIDE(int is_HIDE) {
        this.is_HIDE = is_HIDE;
    }

    public int getIs_READ_ONLY() {
        return is_READ_ONLY;
    }

    public void setIs_READ_ONLY(int is_READ_ONLY) {
        this.is_READ_ONLY = is_READ_ONLY;
    }

    public int getIs_DEL() {
        return is_DEL;
    }

    public void setIs_DEL(int is_DEL) {
        this.is_DEL = is_DEL;
    }

    public String getAdd_DATETIME() {
        return add_DATETIME;
    }

    public void setAdd_DATETIME(String add_DATETIME) {
        this.add_DATETIME = add_DATETIME;
    }

    public String getUpdate_DATETIME() {
        return update_DATETIME;
    }

    public void setUpdate_DATETIME(String update_DATETIME) {
        this.update_DATETIME = update_DATETIME;
    }

    public String getDel_DATETIME() {
        return del_DATETIME;
    }

    public void setDel_DATETIME(String del_DATETIME) {
        this.del_DATETIME = del_DATETIME;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("toString : ");
        ret.append(", project_ID='" + project_ID + "'");
        ret.append(", service_ID='" + service_ID + "'");
        ret.append(", project_NAME='" + project_NAME + "'");
        ret.append(", project_INFO='" + project_INFO + "'");
        ret.append(", type='" + type + "'");
        ret.append(", is_HIDE='" + is_HIDE + "'");
        ret.append(", is_READ_ONLY='" + is_READ_ONLY + "'");
        ret.append(", is_DEL='" + is_DEL + "'");
        ret.append(", add_DATETIME='" + add_DATETIME + "'");
        ret.append(", update_DATETIME='" + update_DATETIME + "'");
        ret.append(", del_DATETIME='" + del_DATETIME + "'");
        return ret.toString();
    }
}