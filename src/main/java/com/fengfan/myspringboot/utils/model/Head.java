package com.fengfan.myspringboot.utils.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 * @author ken
 * @date 2019/11/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Head {
    /*@NotBlank(message = "apiCode不能为空")
    private String apiCode;
    @NotBlank(message = "tranId不能为空")
    private String tranId;
    @NotBlank(message = "tranSource不能为空")
    private String tranSource;
    @NotBlank(message = "tranTime不能为空")
    private String tranTime;
    @NotBlank(message = "signature不能为空")
    private String signature;
    private Integer costTime;*/
    private String busCode;
    private String busMsg;

}
