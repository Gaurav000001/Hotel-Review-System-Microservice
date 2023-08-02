package com.micro.hotel.service;

import com.micro.hotel.exception.HotelException;
import com.micro.hotel.model.Hotel;
import com.micro.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {

        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();

        if(hotels.isEmpty()) throw new HotelException("No Hotel Found");

        return hotels;
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new HotelException("Hotel not found with hotelId: " + hotelId));
    }
}
