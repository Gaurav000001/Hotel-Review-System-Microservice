package com.micro.rating.model.repository;

import com.micro.rating.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

}
