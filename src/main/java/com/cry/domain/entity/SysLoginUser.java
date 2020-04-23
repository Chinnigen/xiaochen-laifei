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
 * @description: 登录用户类
 * @author: Cry
 * @create: 2020-03-19 15:26
 **/
@Entity
@Table(name = "sys_login_user")
@Data
@Accessors(chain = true)
public class SysLoginUser implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "salt")
    private String salt;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "valid_flag")
    private Boolean validFlag;

    @Column(name = "oper_time")
    private Date operTime;

    @Column(name = "oper_id")
    private String operID;

    private List<SysRole> roles;

    public SysLoginUser() {
    }

    public SysLoginUser(Integer id, String userName, String password, String phone, String email, String salt, Date createTime, Boolean validFlag, Date operTime, String operID, List<SysRole> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.salt = salt;
        this.createTime = createTime;
        this.validFlag = validFlag;
        this.operTime = operTime;
        this.operID = operID;
        this.roles = roles;
    }
}
