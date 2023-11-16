package com.rentalhive.rentalhive.service;

import com.rentalhive.rentalhive.model.Equipment;
import com.rentalhive.rentalhive.repository.EquipmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EquipmentServiceTest {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Test
    public void testGetAllEquipment() {
        // Assuming you have some equipment already in the database
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        assertNotNull(equipmentList);
        assertFalse(equipmentList.isEmpty());
    }

    @Test
    public void testGetEquipmentById() {
        // Assuming there is an equipment with ID 1 in the database
        Optional<Equipment> equipmentOptional = equipmentService.getEquipmentById(1);
        assertTrue(equipmentOptional.isPresent());
    }

    @Test
    public void testAddEquipment() {
        Equipment newEquipment = new Equipment();
        newEquipment.setName("New Equipment");
        newEquipment.setQuantity(10);

        Equipment addedEquipment = equipmentService.addEquipment(newEquipment);

        assertNotNull(addedEquipment);
        assertNotNull(addedEquipment.getId());

        // Verify that the equipment is in the database
        Optional<Equipment> retrievedEquipment = equipmentRepository.findById(addedEquipment.getId());
        assertTrue(retrievedEquipment.isPresent());
        assertEquals("New Equipment", retrievedEquipment.get().getName());
    }

    @Test
    public void testUpdateEquipment() {
        // Assuming there is an equipment with ID 1 in the database
        Equipment existingEquipment = equipmentRepository.findById(1).orElseThrow();

        // Update the quantity
        existingEquipment.setQuantity(20);

        Equipment updatedEquipment = equipmentService.updateEquipment(1, existingEquipment);

        assertNotNull(updatedEquipment);
        assertEquals(20, updatedEquipment.getQuantity());
    }

    @Test
    public void testDeleteEquipment() {
        // Assuming there is an equipment with ID 1 in the database
        equipmentService.deleteEquipment(1);

        // Verify that the equipment is no longer in the database
        Optional<Equipment> deletedEquipment = equipmentRepository.findById(1);
        assertTrue(deletedEquipment.isEmpty());
    }
}