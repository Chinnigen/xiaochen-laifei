package com.cry.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: 角色类
 * @author: Cry
 * @create: 2020-03-20 08:56
 **/
@Entity
@Table(name = "sys_role")
@Data
@Accessors(chain = true)
public class SysRole implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

    @Column(name = "valid_flag")
    private Boolean validFlag;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "oper_id")
    private String operID;

    @Column(name = "oper_time")
    private Date operTime;

    private List<SysPermission> permissions;

    public SysRole() {
    }

    public SysRole(Integer id, String roleName, String description, Boolean validFlag, Date createTime, String operID, Date operTime, List<SysPermission> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.validFlag = validFlag;
        this.createTime = createTime;
        this.operID = operID;
        this.operTime = operTime;
        this.permissions = permissions;
    }
}
