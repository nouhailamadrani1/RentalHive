package com.rentalhive.rentalhive.repository;


import com.rentalhive.rentalhive.model.Resevration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Resevration ,Integer> {
}
