package com.micro.user.exception;

public class UserException extends RuntimeException{

    public UserException(){
        super("User exception occured");
    }

    public UserException(String message){
        super(message);
    }
}
