package com.zhousz.ms.exception;

import com.zhousz.ms.util.CodeMsg;
import com.zhousz.ms.util.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException)e;
            return Result.error(exception.getCm());
        }
        if (e instanceof BindException) {
            BindException bindException = (BindException)e;
            List<ObjectError> errors = bindException.getAllErrors();
            String msg = errors.get(0).getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillMsg(msg));
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
