package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository  extends JpaRepository<Laboratory, Integer> {
}
