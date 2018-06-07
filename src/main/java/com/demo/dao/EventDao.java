package com.demo.dao;


import com.demo.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface EventDao {

	List<Event> getByMap(Map<String, Object> map);

	Event getById(Integer id);

	Integer create(Event event);

	int update(Event event);

	int delete(Integer id);

}