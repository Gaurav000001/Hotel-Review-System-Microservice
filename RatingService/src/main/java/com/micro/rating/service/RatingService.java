package com.micro.rating.service;

import com.micro.rating.model.Rating;

import java.util.List;

public interface RatingService {

    //create
    public Rating createRating(Rating rating);

    /**
     * get All ratings by userId
     * @param userId
     * @return List<Rating>
     */
    public List<Rating> getAllRatingsByUserId(String userId);

    /**
     * get All ratings by hotelId
     * @param hotelId
     * @return List<Rating>
     */
    public List<Rating> getAllRatingsByHotelId(String hotelId);

    public List<Rating> getAllRatings();
}
