package com.nikkhat.UserService.external;

import com.nikkhat.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name ="HOTEL_SERVICE")
//public interface HotelService {
//
//    @GetMapping("/hotel/{hotelId}")
//    Hotel getHotel(@PathVariable ("hotelId")String hotelId);
//}

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("hotel/{hotelId}")
    Hotel getHotel(@PathVariable ("hotelId") String hotelId);

}