package com.geekster.University.Event.Management.controller;

import com.geekster.University.Event.Management.model.Department;
import com.geekster.University.Event.Management.model.Event;
import com.geekster.University.Event.Management.model.Student;
import com.geekster.University.Event.Management.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;


    @GetMapping("events")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    //Add a student

    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    //delete a Event

    @DeleteMapping("events/{id}")
    public String deleteEventById(@PathVariable Long id){
        return eventService.deleteEventById(id);
    }

    //update locationOfEvent

    @PutMapping("event/{id}/{location}")
    public String updateLocationById(@PathVariable Long id,@PathVariable String location){
        return eventService.updateLocationById(id,location);
    }

    //Get all Events by date

    @GetMapping("events/date/{date}")
    public List<Event> getEventsByDate(@PathVariable String date){
        return eventService.getEventsByDate(date);
    }
}
