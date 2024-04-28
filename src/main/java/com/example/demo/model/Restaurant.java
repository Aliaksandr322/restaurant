package com.example.demo.model;

import com.example.demo.enums.TypeOfRestaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private Long id;
    private String restaurantName;
    private String address;
    private Double rating;
//    @OneToMany
//    //TODO
////    @JoinColumn(name ="user")
//    private List<Comment> comments;
//    @OneToMany
//    @JoinColumn(name = "table_id")
//    private Set<TableN> tables;
//    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinTable(name = "restaurant_reservation",
//            joinColumns = { @JoinColumn(name = "restaurant_id", referencedColumnName="ID") },
//            inverseJoinColumns = {
//            @JoinColumn(name = "reservation_id", referencedColumnName="ID") })
//    private List<Reservation> reservations;
    private String phoneNumber;
    private String workTime;
    @Column(name = "restaurant_type")
    @Enumerated(EnumType.STRING)
    private TypeOfRestaurant restaurantType;
}
