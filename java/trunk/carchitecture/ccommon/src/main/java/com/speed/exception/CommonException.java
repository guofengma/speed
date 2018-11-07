package com.speed.exception;

public class CommonException extends RuntimeException{
    private String errorCode;

    public CommonException(String errorCode) {
        this.errorCode = errorCode;
    }

    public CommonException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommonException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public CommonException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
