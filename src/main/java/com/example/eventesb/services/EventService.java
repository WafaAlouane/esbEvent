package com.example.eventesb.services;


import com.example.eventesb.entities.Equipment;
import com.example.eventesb.entities.Event;
import com.example.eventesb.entities.Room;
import com.example.eventesb.repositories.EquipmentRepository;
import com.example.eventesb.repositories.EventRepository;
import com.example.eventesb.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createEvent(Event event, Long roomId, List<Long> equipmentIds) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room != null) {
            event.setRoom(room);
            List<Equipment> equipments = equipmentRepository.findAllById(equipmentIds);
            event.setEquipments(equipments);
            return eventRepository.save(event);
        }
        return null;
    }

    public Event updateEvent(Long id, Event eventDetails, Long roomId, List<Long> equipmentIds) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            Room room = roomRepository.findById(roomId).orElse(null);
            if (room != null) {
                event.setRoom(room);
                List<Equipment> equipments = equipmentRepository.findAllById(equipmentIds);
                event.setEquipments(equipments);
                event.setName(eventDetails.getName());
                event.setDescription(eventDetails.getDescription());
                event.setDateTime(eventDetails.getDateTime());
                event.setLocation(eventDetails.getLocation());
                return eventRepository.save(event);
            }
        }
        return null;
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
