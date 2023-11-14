package com.rentalhive.rentalhive.service;

import com.rentalhive.rentalhive.model.Equipment;
import com.rentalhive.rentalhive.model.Reservation;
import com.rentalhive.rentalhive.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipment() {
        return (List<Equipment>) equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentById(int id) {
        return equipmentRepository.findById(id);
    }

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(int id, Equipment equipment) {
        equipment.setId(id);
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(int id) {
        equipmentRepository.deleteById(id);
    }
}
