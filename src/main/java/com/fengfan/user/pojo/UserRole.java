package com.fengfan.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户权限表
 *
 * @author f
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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