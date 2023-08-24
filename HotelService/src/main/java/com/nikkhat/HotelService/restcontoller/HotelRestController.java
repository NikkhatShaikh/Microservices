package com.nikkhat.HotelService.restcontoller;

import com.nikkhat.HotelService.entity.Hotel;
import com.nikkhat.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelRestController {

    @Autowired
   private HotelService hotelService;

    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>>getAll(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel>getHotel(@PathVariable  String hotelId){
        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }
}
