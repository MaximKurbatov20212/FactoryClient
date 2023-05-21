package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Expert;
import org.springframework.data.repository.CrudRepository;

public interface ExpertRepository extends CrudRepository<Expert, Integer> {
}
