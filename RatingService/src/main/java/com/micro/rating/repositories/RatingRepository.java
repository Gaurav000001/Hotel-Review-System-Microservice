package com.micro.rating.repositories;

import com.micro.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    public List<Rating> findByUserId(String userId);

    public List<Rating> findByHotelId(String hotelId);
}
