package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import org.springframework.data.repository.CrudRepository;

public interface ExpertTestRepository  extends CrudRepository<ExpertTest, Integer> {
}
