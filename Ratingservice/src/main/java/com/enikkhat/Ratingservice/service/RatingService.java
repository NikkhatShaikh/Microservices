package com.enikkhat.Ratingservice.service;

import com.enikkhat.Ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {


    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    //get All Ratings by ratingByID
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotel(String hotelId);


}
