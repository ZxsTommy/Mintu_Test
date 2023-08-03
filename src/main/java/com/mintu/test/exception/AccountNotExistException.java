package com.mintu.test.exception;

public class AccountNotExistException extends RuntimeException{

    public AccountNotExistException(){}

    public AccountNotExistException(String msg){super(msg);}

    public AccountNotExistException(Throwable cause){super(cause);}

    public AccountNotExistException(String msg, Throwable cause){super(msg,cause);}

}
