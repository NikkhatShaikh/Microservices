package com.nikkhat.UserService.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;


}
