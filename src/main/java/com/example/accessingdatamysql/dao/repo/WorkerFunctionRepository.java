package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.WorkerFunction;
import org.springframework.data.repository.CrudRepository;

public interface WorkerFunctionRepository  extends CrudRepository<WorkerFunction, Integer> {
}
