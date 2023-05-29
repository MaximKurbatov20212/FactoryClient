package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> { }
