package com.cry.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: xiaochen-laofei
 * @description: 访问记录类
 * @author: Cry
 * @create: 2020-03-07 10:25
 **/
@Entity
@Table(name = "sys_login_record")
public class SysLoginRecord implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "login_ip")
    private String loginIP;

    @Column(name = "valid_flag")
    private Boolean validFlag;

    @Column(name = "oper_time")
    private Date operTime;

    @Column(name = "oper_id")
    private String operID;

    public SysLoginRecord() {
    }

    public SysLoginRecord(Integer id, Date loginTime, String loginIP, Boolean validFlag, Date operTime, String operID) {
        this.id = id;
        this.loginTime = loginTime;
        this.loginIP = loginIP;
        this.validFlag = validFlag;
        this.operTime = operTime;
        this.operID = operID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Boolean getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Boolean validFlag) {
        this.validFlag = validFlag;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOperID() {
        return operID;
    }

    public void setOperID(String operID) {
        this.operID = operID;
    }

    @Override
    public String toString() {
        return "SysLoginRecord{" +
                "id=" + id +
                ", loginTime=" + loginTime +
                ", loginIP='" + loginIP + '\'' +
                ", validFlag=" + validFlag +
                ", operTime=" + operTime +
                ", operID='" + operID + '\'' +
                '}';
    }
}
