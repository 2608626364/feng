package com.fengfan.utils.model;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @param <ResponseBody>
 * @author ken
 * @date 2019/5/9
 */
@Data
@Log4j2
public class ResponseVO<ResponseBody> {
    private Head head;
    private ResponseBody body;

    public ResponseVO() {
    }

    public ResponseVO(Head head, String code, String msg, ResponseBody body) {
        this.head = head;
        this.body = body;
        head.setBusCode(code);
        head.setBusMsg(msg);
    }

    public ResponseVO(String code, String msg, ResponseBody body) {
        this.head = new Head();
        this.body = body;
        head.setBusCode(code);
        head.setBusMsg(msg);
    }
}
