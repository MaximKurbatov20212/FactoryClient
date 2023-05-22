package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Factory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactoryRepository extends JpaRepository<Factory, Integer> {}

