package com.mintu.test.exception;

public class OriginPasswordIncorrectException extends RuntimeException{

    public OriginPasswordIncorrectException(){}

    public OriginPasswordIncorrectException(String msg){super(msg);}

    public OriginPasswordIncorrectException(Throwable cause){super(cause);}

    public OriginPasswordIncorrectException(String msg, Throwable cause){super(msg,cause);}

}
