package com.example.accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Site;
import org.springframework.data.repository.CrudRepository;

public interface SiteRepository  extends CrudRepository<Site, Integer> {
}
