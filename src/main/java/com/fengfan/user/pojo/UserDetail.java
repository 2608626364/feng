package com.fengfan.user.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户信息表
 */
@Data
public class UserDetail implements Serializable{
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
     * 用户角色表
     */
    private Integer role;

    private static final long serialVersionUID = 1L;
}