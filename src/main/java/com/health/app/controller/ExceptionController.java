package com.health.app.controller;

import com.health.app.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = MyException.class)
    public String getErr(){

        return "";
    }


}
