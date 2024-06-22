package com.micro.rating.exceptions;

public class RatingException extends Exception{

    public RatingException(){
        super("User exception occured");
    }

    public RatingException(String message){
        super(message);
    }
}
