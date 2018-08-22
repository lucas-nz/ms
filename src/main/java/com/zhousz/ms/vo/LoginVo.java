package com.zhousz.ms.vo;

import com.zhousz.ms.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LoginVo {

    @NotNull
    @Length(min = 11, max = 11)
    @IsMobile
    private String mobile;

    @NotNull
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo: [ mobile: " + mobile + ", password: " + password + "]";
    }
}
