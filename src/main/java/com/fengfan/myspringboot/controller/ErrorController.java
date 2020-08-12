package com.fengfan.myspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "出错啦!")
public class ErrorController extends RuntimeException{
}
