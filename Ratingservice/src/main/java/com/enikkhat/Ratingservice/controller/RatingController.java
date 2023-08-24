package com.enikkhat.Ratingservice.controller;

import com.enikkhat.Ratingservice.entity.Rating;
import com.enikkhat.Ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok().body(ratingService.getAllRatings());
    }


    @GetMapping("userId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok().body(ratingService.getRatingByUserId(userId));
    }


    @GetMapping("/hotelId/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingsByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok().body(ratingService.getRatingByHotel(hotelId));
    }


}
