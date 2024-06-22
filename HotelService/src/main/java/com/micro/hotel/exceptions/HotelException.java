package com.micro.hotel.exceptions;

public class HotelException extends RuntimeException{

    public HotelException(){
        super("User exception occured");
    }

    public HotelException(String message){
        super(message);
    }
}
