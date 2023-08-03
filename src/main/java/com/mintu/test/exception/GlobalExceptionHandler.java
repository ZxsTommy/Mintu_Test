package com.mintu.test.exception;


import com.mintu.test.response.ResponseCode;
import com.mintu.test.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackages = "com.mintu.test.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseResult<?> handleException(Exception e){
        e.printStackTrace();
        if (e instanceof AccountNotExistException){
            return new ResponseResult(ResponseCode.ACCOUNT_NOT_EXIST);
        } else if (e instanceof PasswordIncorrectException) {
            return new ResponseResult(ResponseCode.PASSWORD_INCORRECT);
        } else if (e instanceof OriginPasswordIncorrectException) {
            return new ResponseResult(ResponseCode.ORIGIN_PASSWORD_INCORRECT);
        } else if (e instanceof AccountExistedException) {
            return new ResponseResult(ResponseCode.ACCOUNT_EXISTED);
        }
        return ResponseResult.failure();
    }

}
