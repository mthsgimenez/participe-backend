package com.mthsgimenez.participe.controller;

import com.mthsgimenez.participe.domain.event.Event;
import com.mthsgimenez.participe.domain.event.EventRequestDTO;
import com.mthsgimenez.participe.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@ModelAttribute EventRequestDTO data) {
        Event newEvent = eventService.createEvent(data);
        if (newEvent == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(newEvent);
    }
}
