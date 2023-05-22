package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.PersonalAccounting;
import org.springframework.data.repository.CrudRepository;

public interface PersonalAccountingRepository extends CrudRepository<PersonalAccounting, Integer> {
}
