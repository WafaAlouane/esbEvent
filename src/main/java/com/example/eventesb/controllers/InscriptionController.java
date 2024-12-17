package com.example.eventesb.controllers;

import com.example.eventesb.entities.Inscription;
import com.example.eventesb.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @GetMapping("/event/{eventId}")
    public List<Inscription> getInscriptionsByEventId(@PathVariable Long eventId) {
        return inscriptionService.getInscriptionsByEventId(eventId);
    }

    @GetMapping("/user/{userId}")
    public List<Inscription> getInscriptionsByUserId(@PathVariable Long userId) {
        return inscriptionService.getInscriptionsByUserId(userId);
    }

    @PostMapping("/{userId}/{eventId}")
    public Inscription createInscription(@PathVariable Long userId, @PathVariable Long eventId) {
        return inscriptionService.createInscription(userId, eventId);
    }
    @PutMapping("/{id}")
    public Inscription updateInscription(@PathVariable Long id, @RequestBody Inscription inscriptionDetails) {
        return inscriptionService.updateInscription(id, inscriptionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }

    @PutMapping("/confirm/{id}")
    public Inscription confirmInscription(@PathVariable Long id) {
        return inscriptionService.confirmInscription(id);
    }
}
