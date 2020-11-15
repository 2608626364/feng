package com.fengfan.user.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 用户id
    */
    private Integer uid;

    /**
    * 权限id
    */
    private Integer rid;

    private static final long serialVersionUID = 1L;
}