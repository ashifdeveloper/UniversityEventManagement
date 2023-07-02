package com.geekster.University.Event.Management.repository;

import com.geekster.University.Event.Management.model.Event;
import com.geekster.University.Event.Management.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEventRepo extends CrudRepository<Event,Long> {
    List<Event> findByDate(String date);

}
