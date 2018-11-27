package com.demo.exception;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
