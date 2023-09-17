package com.micro.hotel.controller;

import com.micro.hotel.model.Hotel;
import com.micro.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/micro/hotels/")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotelHandler(@RequestBody Hotel hotel){

        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotelsHandler(){

        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("{hotelId}/")
    public ResponseEntity<Hotel> getHotelHandler(@PathVariable String hotelId){

        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }
}
