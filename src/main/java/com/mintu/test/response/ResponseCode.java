package com.mintu.test.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    ACCOUNT_NOT_EXIST(101,"账号不存在"),

    ORIGIN_PASSWORD_INCORRECT(103,"初始密码不正确"),
    PASSWORD_INCORRECT(102,"密码错误"),

    ACCOUNT_EXISTED(104,"账号已存在"),
    SUCCESS(200, "成功"),
    FAILURE(500, "失败");


    private int code;
    private String msg;

}
