package com.nikkhat.HotelService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "micro_hotel")
public class Hotel {
    @Id
    @Column(name = "ID")
    private String id;
    private String name;
    private String location;
    private String about;

}
