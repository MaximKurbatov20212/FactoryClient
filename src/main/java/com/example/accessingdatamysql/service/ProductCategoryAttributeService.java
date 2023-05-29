package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import com.example.accessingdatamysql.dao.repo.ProductCategoryAttributeRepository;
import com.example.accessingdatamysql.dto.ProductCategoryAttributeDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductCategoryAttributeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductCategoryAttributeService implements com.example.accessingdatamysql.service.Service<ProductCategoryAttributeDTO> {
    private final ProductCategoryAttributeRepository repo;
    private final ProductCategoryAttributeMapper mapper;

    public List<ProductCategoryAttributeDTO> getAll() {
        List<ProductCategoryAttribute> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<ProductCategoryAttributeDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(ProductCategoryAttributeDTO dto) {
        try {
            ProductCategoryAttribute e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductCategoryAttributeDTO dto) {
        ProductCategoryAttribute e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(ProductCategoryAttributeDTO dto) {
        ProductCategoryAttribute e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
