package com.fengfan.utils.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

/**
 * @author ken
 * @date 2019/11/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestVO<RequestBody> {
    @Valid
    private Head head;
    @Valid
    private RequestBody body;

}
