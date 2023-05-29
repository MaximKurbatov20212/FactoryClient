package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductCategory;
import com.example.accessingdatamysql.dao.repo.ProductCategoryRepository;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductCategoryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ProductCategoryService implements Service<ProductCategoryDTO>{
    private final ProductCategoryRepository repo;
    private final ProductCategoryMapper mapper;

    @Override
    public List<ProductCategoryDTO> getAll() {
        List<ProductCategory> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<ProductCategoryDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(ProductCategoryDTO dto) {
        try {
            ProductCategory e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(ProductCategoryDTO dto) {
        ProductCategory e = mapper.toEntity(dto);
        repo.save(e);
    }

    @Override
    public void drop(ProductCategoryDTO dto) {
        ProductCategory e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
