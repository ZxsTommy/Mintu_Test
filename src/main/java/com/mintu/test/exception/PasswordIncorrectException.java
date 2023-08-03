package com.mintu.test.exception;

public class PasswordIncorrectException extends RuntimeException{

    public PasswordIncorrectException(){}

    public PasswordIncorrectException(String msg){super(msg);}

    public PasswordIncorrectException(Throwable cause){super(cause);}

    public PasswordIncorrectException(String msg, Throwable cause){super(msg,cause);}

}
