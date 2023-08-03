package com.mintu.test.response;

import lombok.Data;


@Data
public class ResponseResult<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseResult(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    public ResponseResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public ResponseResult() {
    }

    public static <T> ResponseResult<T> build(ResponseCode responseCode, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(responseCode.getCode());
        result.setMsg(responseCode.getMsg());
        return result;
    }

    public static ResponseResult<Void> success() {
        return new ResponseResult<>(ResponseCode.SUCCESS);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS, data);
    }

    public static ResponseResult<Void> failure() {
        return new ResponseResult<>(ResponseCode.FAILURE);
    }

    public static <T> ResponseResult<T> failure(T data) {
        return new ResponseResult<>(ResponseCode.FAILURE, data);
    }
}
