package com.company.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Galapagos on 2016/4/30.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger=Logger.getLogger(GlobalExceptionHandler.class);



    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason="reason 404")
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest httpServletRequest,Exception exception){

        logger.debug(httpServletRequest.toString());
        logger.debug(exception.toString());
        return "error";
    }


}
