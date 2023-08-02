package com.micro.rating.controller;

import com.micro.rating.model.Rating;
import com.micro.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("micro")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRatingHandler(@RequestBody Rating rating){

        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    @GetMapping("/ratings/users/{userId}")
    public ResponseEntity<List<Rating>> GetAllRatingByUserIdHandler(@PathVariable String userId){

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingsByUserId(userId));
    }

    @GetMapping("/ratings/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> GetAllRatingByHotelIdHandler(@PathVariable String hotelId){

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingsByHotelId(hotelId));
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> GetAllRatingsHandler(){

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }
}
