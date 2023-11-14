package com.rentalhive.rentalhive.service;

import com.rentalhive.rentalhive.model.Reservation;
import com.rentalhive.rentalhive.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(int id) {
        return reservationRepository.findById(id);
    }



    public Reservation updateResevration(int id, Reservation reservation)    {
       reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    public Reservation addResevration(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


}
