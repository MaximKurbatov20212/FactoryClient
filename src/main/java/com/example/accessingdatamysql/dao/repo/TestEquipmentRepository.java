package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.TestEquipment;
import org.springframework.data.repository.CrudRepository;

public interface TestEquipmentRepository  extends CrudRepository<TestEquipment, Integer> {
}
