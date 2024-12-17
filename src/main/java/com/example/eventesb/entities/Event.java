package com.example.eventesb.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private LocalDateTime dateTime;
        private String location;
        @OneToMany(mappedBy = "event")
        private List<Inscription> inscriptions;

        @ManyToOne
        @JoinColumn(name = "room_id")
        private Room room;

        @ManyToMany
        @JoinTable(
                name = "event_equipment",
                joinColumns = @JoinColumn(name = "event_id"),
                inverseJoinColumns = @JoinColumn(name = "equipment_id")
        )
        private List<Equipment> equipments;

}
