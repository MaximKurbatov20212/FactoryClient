package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductAttributeValue;
import org.springframework.data.repository.CrudRepository;

public interface ProductAttributeValueRepository  extends CrudRepository<ProductAttributeValue, Integer> {
}
