package com.micro.rating.exception;

public class RatingException extends RuntimeException{

    public RatingException(){
        super("User exception occured");
    }

    public RatingException(String message){
        super(message);
    }
}
