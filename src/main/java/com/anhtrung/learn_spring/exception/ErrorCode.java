package com.anhtrung.learn_spring.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"User already existed"),
    USERNAME_EXISTED(1002,"Username already existed"),
    PASSWORD_EXISTED(1003,"Password already existed"),
    USERNAME_INVALID(1004,"Username is invalid"),
    INVALID_PASSWORD(1005,"Password is invalid"),
    INVALID_KEY(1000,"Invalid message key"),
    PASSWORD_NOT_EXISTED(1006,"Password already not existed"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int code;
    private String message;

}
