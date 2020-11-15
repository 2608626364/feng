package com.fengfan.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Administrator
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "出错啦!")
public class ErrorControllerException extends RuntimeException{
    
}
