package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String restaurantName;
    private String address;
    private Double rating;
    @OneToMany
    //TODO
//    @JoinColumn(name ="user")
    private List<Comment> comments;
    @OneToMany
    @JoinColumn(name = "table_id")
    private Set<TableN> tables;
    @ManyToMany
    @JoinTable(name = "restaurant_id", joinColumns = { @JoinColumn(name = "restaurant_id") }, inverseJoinColumns = {
            @JoinColumn(name = "reservation_id") })
    private List<Reservation> reservations;
    private String phoneNumber;
    private String workTime;
    //TODO
    private String restaurantType;
}
