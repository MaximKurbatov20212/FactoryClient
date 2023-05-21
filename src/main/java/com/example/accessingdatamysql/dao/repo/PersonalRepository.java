package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Personal;
import org.springframework.data.repository.CrudRepository;

public interface PersonalRepository extends CrudRepository<Personal, Integer> { }
