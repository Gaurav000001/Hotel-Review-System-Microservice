package com.micro.user.external.services;

import com.micro.user.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/micro/hotels/{hotelId}/")
    public Hotel getHotel(@PathVariable String hotelId);
}
