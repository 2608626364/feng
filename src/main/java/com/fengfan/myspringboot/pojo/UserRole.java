package com.fengfan.myspringboot.pojo;

import java.io.Serializable;
import lombok.Data;

/**
    * 用户权限表
    */
@Data
public class UserRole implements Serializable {
    private Integer id;

    /**
    * 权限id
    */
    private Integer role;

    /**
    * 权限解释
    */
    private String desc;

    private static final long serialVersionUID = 1L;
}