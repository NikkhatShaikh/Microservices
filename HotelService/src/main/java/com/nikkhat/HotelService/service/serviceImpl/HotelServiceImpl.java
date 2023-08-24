package com.nikkhat.HotelService.service.serviceImpl;

import com.nikkhat.HotelService.entity.Hotel;
import com.nikkhat.HotelService.exception.ResourceNotFoundException;
import com.nikkhat.HotelService.repository.HotelRepository;
import com.nikkhat.HotelService.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        System.out.println("ID :: "+randomHotelId);
        hotel.setId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel is Not found for given Hotel Id :: "+hotelId));
    }
}
