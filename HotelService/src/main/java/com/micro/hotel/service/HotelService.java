package com.micro.hotel.service;

import com.micro.hotel.model.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);
}
