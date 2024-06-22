package com.micro.rating.services;

import com.micro.rating.entities.Rating;
import com.micro.rating.exceptions.RatingException;

import java.util.List;

public interface RatingService {

    //create
    public Rating createRating(Rating rating) throws RatingException;

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
