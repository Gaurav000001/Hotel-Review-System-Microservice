package com.micro.rating.services;

import com.micro.rating.exceptions.RatingException;
import com.micro.rating.entities.Rating;
import com.micro.rating.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) throws RatingException {
    	if(rating.getRating() < 1 || rating.getRating() > 5) throw new RatingException("Rating should be from 1 to 5.");
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
