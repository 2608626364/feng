package com.fengfan.utils.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author magy
 * @date 2019/11/22
 */
@Data
public class BaseRequest {
    /**
     * 当前页数
     */
    @NotNull(message = "当前页数不能为空")
    private Integer pageNum;
    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

}
