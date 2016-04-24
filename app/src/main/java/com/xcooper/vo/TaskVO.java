package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * 任务VO
 *
 * @author zdk
 *         2016-03-28 19:34:51
 */
@DatabaseTable(tableName = "task")
public class TaskVO {

    public static final int task_wfqd = 1001;
    public static final int task_wgzd = 1002;
    public static final int task_wfzd = 1003;
    public static final int task_qita = 1004;

    //TASK_ID
    @DatabaseField
    public int task_ID;

    //SERVICE_ID
    @DatabaseField
    public int service_ID;

    //PROJECT_ID
    @DatabaseField
    public int project_ID;

    //LIST_ID
    @DatabaseField
    public int list_ID;

    //TASK_NAME
    @DatabaseField
    public String task_NAME;

    //CREATE_ID
    @DatabaseField
    public int create_ID;

    //执行人id
    @DatabaseField
    public int exe_ID;

    //END_DATETIME
    @DatabaseField
    public String end_DATETIME;

    //TASK_INFO
    @DatabaseField
    public String task_INFO;

    //IS_DEL
    @DatabaseField
    public int is_DEL;

    //ADD_DATETIME
    @DatabaseField
    public String add_DATETIME;

    //UPDATE_DATETIME
    @DatabaseField
    public String update_DATETIME;

    //DEL_DATETIME
    @DatabaseField
    public String del_DATETIME;

    //DEL_DATETIME
    @DatabaseField
    public int is_focus;

    //DEL_DATETIME
    @DatabaseField
    public int type;

    public int getTask_ID() {
        return task_ID;
    }

    public void setTask_ID(int task_ID) {
        this.task_ID = task_ID;
    }

    public int getService_ID() {
        return service_ID;
    }

    public void setService_ID(int service_ID) {
        this.service_ID = service_ID;
    }

    public int getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    public int getList_ID() {
        return list_ID;
    }

    public void setList_ID(int list_ID) {
        this.list_ID = list_ID;
    }

    public String getTask_NAME() {
        return task_NAME;
    }

    public void setTask_NAME(String task_NAME) {
        this.task_NAME = task_NAME;
    }

    public int getCreate_ID() {
        return create_ID;
    }

    public void setCreate_ID(int create_ID) {
        this.create_ID = create_ID;
    }

    public int getExe_ID() {
        return exe_ID;
    }

    public void setExe_ID(int exe_ID) {
        this.exe_ID = exe_ID;
    }

    public String getEnd_DATETIME() {
        return end_DATETIME;
    }

    public void setEnd_DATETIME(String end_DATETIME) {
        this.end_DATETIME = end_DATETIME;
    }

    public String getTask_INFO() {
        return task_INFO;
    }

    public void setTask_INFO(String task_INFO) {
        this.task_INFO = task_INFO;
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

    public int getIs_focus() {
        return is_focus;
    }

    public void setIs_focus(int is_focus) {
        this.is_focus = is_focus;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("toString : ");
        ret.append(", TASK_ID='" + task_ID + "'");
        ret.append(", SERVICE_ID='" + service_ID + "'");
        ret.append(", PROJECT_ID='" + project_ID + "'");
        ret.append(", LIST_ID='" + list_ID + "'");
        ret.append(", TASK_NAME='" + task_NAME + "'");
        ret.append(", CREATE_ID='" + create_ID + "'");
        ret.append(", EXE_ID='" + exe_ID + "'");
        ret.append(", END_DATETIME='" + end_DATETIME + "'");
        ret.append(", TASK_INFO='" + task_INFO + "'");
        ret.append(", IS_DEL='" + is_DEL + "'");
        ret.append(", ADD_DATETIME='" + add_DATETIME + "'");
        ret.append(", UPDATE_DATETIME='" + update_DATETIME + "'");
        ret.append(", DEL_DATETIME='" + del_DATETIME + "'");
        return ret.toString();
    }
}