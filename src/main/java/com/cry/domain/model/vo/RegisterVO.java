package com.cry.domain.model.vo;

import com.cry.common.enums.OperEnum;
import com.cry.domain.entity.SysLoginUser;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha1Hash;

import javax.validation.constraints.NotBlank;

/**
 * @program: xiaochen-laofei
 * @description: 注册VO
 * @author: Cry
 * @create: 2020-03-23 15:04
 **/
public class RegisterVO {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "联系电话不能为空")
    private String phone;

    @NotBlank(message = "邮箱地址不能为空")
    private String email;

    public RegisterVO() {
    }

    public RegisterVO(@NotBlank(message = "用户名不能为空") String userName, @NotBlank(message = "密码不能为空") String password, @NotBlank(message = "联系电话不能为空") String phone, @NotBlank(message = "邮箱地址不能为空") String email) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SysLoginUser toSysLoginUser() {
        SysLoginUser user = new SysLoginUser();
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setUserName(this.userName);
        user.setPassword(new Sha1Hash(this.password, salt, 5).toString());
        user.setPhone(this.phone);
        user.setEmail(this.email);
        user.setOperID(String.valueOf(OperEnum.WEB_MANAGER.operID()));
        user.setSalt(salt);
        return user;
    }
}
