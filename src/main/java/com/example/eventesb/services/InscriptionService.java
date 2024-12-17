package com.example.eventesb.services;

import com.example.eventesb.entities.Inscription;
import com.example.eventesb.entities.User;
import com.example.eventesb.entities.Event;
import com.example.eventesb.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public List<Inscription> getInscriptionsByEventId(Long eventId) {
        return inscriptionRepository.findByEventId(eventId);
    }

    public List<Inscription> getInscriptionsByUserId(Long userId) {
        return inscriptionRepository.findByUserId(userId);
    }

    public Inscription createInscription(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);
        if (user != null && event != null) {
            Inscription inscription = new Inscription();
            inscription.setUser(user);
            inscription.setEvent(event);
            inscription.setInscriptionDate(LocalDateTime.now());
            inscription.setConfirmed(false);
            return inscriptionRepository.save(inscription);
        }
        return null;
    }
    public Inscription updateInscription(Long id, Inscription inscriptionDetails) {
        Inscription inscription = inscriptionRepository.findById(id).orElse(null);
        if (inscription != null) {
            inscription.setConfirmed(inscriptionDetails.isConfirmed());
            inscription.setInscriptionDate(inscriptionDetails.getInscriptionDate());
            return inscriptionRepository.save(inscription);
        }
        return null;
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    public Inscription confirmInscription(Long id) {
        Inscription inscription = inscriptionRepository.findById(id).orElse(null);
        if (inscription != null) {
            inscription.setConfirmed(true);
            return inscriptionRepository.save(inscription);
        }
        return null;
    }
}
