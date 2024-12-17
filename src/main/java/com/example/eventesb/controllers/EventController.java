package com.example.eventesb.controllers;


import com.example.eventesb.entities.Event;
import com.example.eventesb.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/showbyid/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/addevent")
    public Event createEvent(@RequestBody Event event, @RequestParam Long roomId, @RequestParam List<Long> equipmentIds) {
        return eventService.createEvent(event, roomId, equipmentIds);
    }

    @PutMapping("/updateevent/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails, @RequestParam Long roomId, @RequestParam List<Long> equipmentIds) {
        return eventService.updateEvent(id, eventDetails, roomId, equipmentIds);
    }

    @DeleteMapping("/deleteevent/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
