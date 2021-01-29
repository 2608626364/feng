package com.fengfan.user.pojo;

import com.fengfan.request.Body;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author f
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements Serializable, Body {
    /**
     * 用户主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户角色
     */
    private Integer role;

    /**
     * 用户注册时间
     */
    private Date userRegistertime;

    /**
     * 用户修改时间
     */
    private Date userUpdatetime;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 是否禁用
     */
    private String disable;

    private static final long serialVersionUID = 1L;
}