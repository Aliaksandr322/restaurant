package com.example.demo.service.restaurant;

import com.example.demo.model.Reservation;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository repository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;


    public ReservationServiceImpl(ReservationRepository repository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public void saveReservation(Long userId, Long restaurantId, Reservation reservation) {
        reservation.setUser(userRepository.findById(userId).get());
        reservation.setRestaurant(restaurantRepository.findById(restaurantId).get());
        repository.save(reservation);
    }

    @Override
    public List<Restaurant> findAllReservations() {
        return null;
    }

    @Override
    public void removeReservation(Long id) {

    }

    @Override
    public void updateReservation(Long id, Reservation reservation) {

    }

    @Override
    public Reservation findById(Long id) {
        return null;
    }
}
