package com.xcooper.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "user")
public class UserVO {

    @DatabaseField
    String name;
    @DatabaseField
    String tele;
    @DatabaseField
    String pwd;
    @DatabaseField
    String current_state;
    @DatabaseField
    String current_order;
    @DatabaseField
    String tokenValues;
    @DatabaseField
    String tokentime;
    @DatabaseField
    String last_order;
    @DatabaseField
    String channel_id;
    @DatabaseField
    int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getLast_order() {
        return last_order;
    }

    public void setLast_order(String last_order) {
        this.last_order = last_order;
    }

    public String getTokenValues() {
        return tokenValues;
    }

    public void setTokenValues(String tokenValues) {
        this.tokenValues = tokenValues;
    }

    public String getTokentime() {
        return tokentime;
    }

    public void setTokentime(String tokentime) {
        this.tokentime = tokentime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    public String getCurrent_order() {
        return current_order;
    }

    public void setCurrent_order(String current_order) {
        this.current_order = current_order;
    }
}
