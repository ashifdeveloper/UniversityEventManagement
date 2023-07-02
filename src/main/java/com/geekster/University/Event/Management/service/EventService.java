package com.geekster.University.Event.Management.service;

import com.geekster.University.Event.Management.model.Event;
import com.geekster.University.Event.Management.model.Student;
import com.geekster.University.Event.Management.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public String addEvent(Event event) {
            eventRepo.save(event);
            return "Added";

    }

    public String deleteEventById(Long id) {
        Optional<Event> myEventOpt = eventRepo.findById(id);
        Event myEvent = null;
        if(myEventOpt.isPresent()){
            myEvent=myEventOpt.get();
        }
        else{
            return "Id Not Found";
        }

        eventRepo.deleteById(id);
        return "Deleted for id "+id;
    }

    public String updateLocationById(Long id, String location) {
        Optional<Event> myEventOpt = eventRepo.findById(id);
        Event myEvent = null;
        if(myEventOpt.isPresent()){
            myEvent=myEventOpt.get();
        }
        else{
            return "Id Not Found";
        }

        myEvent.setLocationOfEvent(location);
        eventRepo.save(myEvent);
        return "Updated for id "+id;

    }

    public List<Event> getEventsByDate(String date) {
        return eventRepo.findByDate(date);

    }
}
