package com.rentalhive.rentalhive.controller;

import com.rentalhive.rentalhive.model.Reservation;
import com.rentalhive.rentalhive.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable int id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation resevration) {
        return reservationService.addResevration(resevration);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return reservationService.updateResevration(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
