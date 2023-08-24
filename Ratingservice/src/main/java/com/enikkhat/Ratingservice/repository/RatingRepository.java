package com.enikkhat.Ratingservice.repository;

import com.enikkhat.Ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {


    //custom methods
    List<Rating> findByUserId(String userID);

    List<Rating>findByHotelId(String hotelId);
}
