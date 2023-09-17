package com.micro.rating.service;

import com.micro.rating.exception.RatingException;
import com.micro.rating.model.Rating;
import com.micro.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
    	if(rating.getRating() < 1 || rating.getRating() > 5) throw new RatingException("Rating should be from 1 to 5.");
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingsByUserId(String userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);

        if(ratings.isEmpty()) throw new RatingException("No ratings found for provided userId: " + userId);

        return ratings;
    }

    @Override
    public List<Rating> getAllRatingsByHotelId(String hotelId) {
        List<Rating> ratings = ratingRepository.findByHotelId(hotelId);

        if(ratings.isEmpty()) throw new RatingException("No ratings found for provided hotelId: " + hotelId);

        return ratings;
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratings = ratingRepository.findAll();

        if(ratings.isEmpty()) throw new RatingException("No ratings found");

        return ratings;
    }
}
