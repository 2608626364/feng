package com.fengfan.user.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户权限表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
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