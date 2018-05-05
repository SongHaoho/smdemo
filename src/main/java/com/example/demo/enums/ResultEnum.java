package com.example.demo.enums;

public enum ResultEnum {
    DATABASE_OPERATE(100,"数据库操作异常"),
    PARAMETER_NULL(101,"必要参数为空"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
