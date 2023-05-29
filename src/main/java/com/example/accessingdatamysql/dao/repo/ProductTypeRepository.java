package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository  extends JpaRepository<ProductType, Integer> {
}
