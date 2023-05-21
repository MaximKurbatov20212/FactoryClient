package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.EventWithPeople;
import org.springframework.data.repository.CrudRepository;

public interface EventWithPeopleRepository  extends CrudRepository<EventWithPeople, Integer> {
}
