package com.nikkhat.UserService.service;

import com.nikkhat.UserService.entity.Hotel;
import com.nikkhat.UserService.entity.Ratings;
import com.nikkhat.UserService.entity.User;
import com.nikkhat.UserService.exception.ResourceNotFoundException;
import com.nikkhat.UserService.external.HotelService;
import com.nikkhat.UserService.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        String randonUserID = UUID.randomUUID().toString();
        user.setUserID(randonUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userID) {
        User user = userRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException("user with given Id is not Found In DB " + userID));


        System.out.println("User Data :: "+user.toString());
        //get ratingsOfUser from Rating_service

        //localhost:8083/ratings/userId/25e6647d-7d59-472c-80f2-efb685032102
//        Ratings[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/userId/"+user.getUserID(), Ratings[].class);
        Ratings[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/userId/" + user.getUserID(), Ratings[].class);


        logger.info("{}", ratingsOfUser);

        assert ratingsOfUser != null;
        List<Ratings> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Ratings> ratingList = ratings.stream().map(rating ->

        {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotel/3d08b209-0288-47ca-803c-7d5a55ab475d

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotel/"+rating.getHotelId(), Hotel.class);
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            Hotel hotel = forEntity.getBody();

//            logger.info("Response Status Code : {} ",forEntity.getStatusCode());

            //set the hotel to rating
            rating.setHotel(hotel);

            //return the rating
            return rating;
        }).collect(Collectors.toList());



        user.setRatings(ratingList);

        return user;
    }

}
