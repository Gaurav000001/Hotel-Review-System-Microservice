package com.micro.rating.controllers;

import com.micro.rating.entities.Rating;
import com.micro.rating.exceptions.RatingException;
import com.micro.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/micro/ratings/")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRatingHandler(@RequestBody Rating rating) throws RatingException {

        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    @GetMapping("users/{userId}/")
    public ResponseEntity<List<Rating>> GetAllRatingByUserIdHandler(@PathVariable String userId){

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingsByUserId(userId));
    }

    @GetMapping("hotels/{hotelId}/")
    public ResponseEntity<List<Rating>> GetAllRatingByHotelIdHandler(@PathVariable String hotelId){

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingsByHotelId(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> GetAllRatingsHandler(){

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }
}
