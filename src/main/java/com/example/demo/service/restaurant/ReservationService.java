package com.example.demo.service.restaurant;

import com.example.demo.model.Reservation;
import com.example.demo.model.Restaurant;

import java.util.List;

public interface ReservationService {

    void saveReservation(Long userId, Long restaurantId, Reservation reservation);

    List<Restaurant> findAllReservations();

    void removeReservation(Long id);
    void updateReservation(Long id,Reservation reservation);

    Reservation findById(Long id);


}
