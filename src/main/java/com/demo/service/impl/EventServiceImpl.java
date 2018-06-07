package com.demo.service.impl;

import com.demo.dao.EventDao;
import com.demo.entity.Event;
import com.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public List<Event> getByMap(Map<String, Object> map) {
        return eventDao.getByMap(map);
    }

    @Override
    public Event getById(Integer id) {
        return eventDao.getById(id);
    }

    @Override
    public Event create(Event event) {

        eventDao.create(event);

        return event;
    }

    @Override
    public Event update(Event event) {

        eventDao.update(event);

        return event;
    }

    @Override
    public int delete(Integer id) {

        return eventDao.delete(id);
    }
}
