package com.mintu.test.exception;

public class AccountExistedException extends RuntimeException{

    public AccountExistedException(){}

    public AccountExistedException(String msg){super(msg);}

    public AccountExistedException(Throwable cause){super(cause);}

    public AccountExistedException(String msg, Throwable cause){super(msg,cause);}

}
