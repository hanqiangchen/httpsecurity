package com.demo.exception;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
public class UsernameIsExitedException extends BaseException {
    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}
