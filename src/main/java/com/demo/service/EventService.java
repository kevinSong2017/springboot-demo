package com.demo.service;

import com.demo.entity.Event;

import java.util.List;
import java.util.Map;

public interface EventService {

    List<Event> getByMap(Map<String,Object> map);

    Event getById(Integer id);

    Event create(Event event);

    Event update(Event event);

    int delete(Integer id);

}
