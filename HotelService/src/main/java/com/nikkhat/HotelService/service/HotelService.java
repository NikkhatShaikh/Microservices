package com.nikkhat.HotelService.service;

import com.nikkhat.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotel(String hotelId);
}
