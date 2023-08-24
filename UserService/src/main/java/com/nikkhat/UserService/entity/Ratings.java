package com.nikkhat.UserService.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Ratings {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;
    private String feedback;

    private Hotel hotel;

}
