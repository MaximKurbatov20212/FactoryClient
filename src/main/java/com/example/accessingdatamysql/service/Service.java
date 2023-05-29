package com.example.accessingdatamysql.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    List<T> getAll();
    Optional<T> getById(int id);
    void add(T dto);
    void edit(T dto);
    void drop(T dto);
}
