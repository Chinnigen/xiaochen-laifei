package com.cry.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: xiaochen-laofei
 * @description: 系统权限类
 * @author: Cry
 * @create: 2020-03-19 16:06
 **/
@Entity
@Table(name = "sys_permission")
public class SysPermission implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "valid_flag")
    private Boolean validFlag;

    @Column(name = "oper_time")
    private Date operTime;

    @Column(name = "oper_id")
    private String operID;

    public SysPermission() {
    }

    public SysPermission(Integer id, String permissionName, String description, Date createTime, Boolean validFlag, Date operTime, String operID) {
        this.id = id;
        this.permissionName = permissionName;
        this.description = description;
        this.createTime = createTime;
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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}
