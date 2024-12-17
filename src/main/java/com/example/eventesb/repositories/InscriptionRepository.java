package com.example.eventesb.repositories;

import com.example.eventesb.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findByEventId(Long eventId);
    List<Inscription> findByUserId(Long userId);
}
