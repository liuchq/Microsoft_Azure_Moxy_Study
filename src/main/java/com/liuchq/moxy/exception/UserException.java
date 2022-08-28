package com.liuchq.moxy.exception;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description: 用户异常
 * @author: liuchq
 * @create: 2021-05-17
 **/
public class UserException extends Exception{
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
