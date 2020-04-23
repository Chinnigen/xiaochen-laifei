package com.cry.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

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
@Data
@Accessors(chain = true)
public class SysLoginRecord implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userID;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "login_ip")
    private String loginIP;

    @Column(name = "valid_flag")
    private Boolean validFlag;

    @Column(name = "oper_time")
    private Date operTime;

    @Column(name = "oper_id")
    private Integer operID;

    public SysLoginRecord() {
    }

    public SysLoginRecord(Integer id, Integer userID, Date loginTime, String loginIP, Boolean validFlag, Date operTime, Integer operID) {
        this.id = id;
        this.userID = userID;
        this.loginTime = loginTime;
        this.loginIP = loginIP;
        this.validFlag = validFlag;
        this.operTime = operTime;
        this.operID = operID;
    }

}
