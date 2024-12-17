package com.example.eventesb.controllers;

import com.example.eventesb.entities.Equipment;
import com.example.eventesb.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @GetMapping("/showbyid/{id}")
    public Equipment getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @PostMapping("/addEquipment")
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @PutMapping("/updateEquipment/{id}")
    public Equipment updateEquipment(@PathVariable Long id, @RequestBody Equipment equipmentDetails) {
        return equipmentService.updateEquipment(id, equipmentDetails);
    }

    @DeleteMapping("/deleteEquipment/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}
