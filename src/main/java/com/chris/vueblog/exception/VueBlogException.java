package com.chris.vueblog.exception;

import com.chris.vueblog.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VueBlogException {
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        return Result.fail(e.getMessage());
    }

}
