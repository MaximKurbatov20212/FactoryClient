package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import org.springframework.data.repository.CrudRepository;

public interface WorkerCategoryRepository  extends CrudRepository<WorkerCategory, Integer> {
}
