package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryAttributeRepository  extends CrudRepository<ProductCategoryAttribute, Integer> {
}
