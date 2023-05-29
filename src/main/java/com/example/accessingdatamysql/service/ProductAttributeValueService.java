package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductAttributeValue;
import com.example.accessingdatamysql.dao.repo.ProductAttributeValueRepository;
import com.example.accessingdatamysql.dto.ProductAttributeValueDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductAttributeValueMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductAttributeValueService implements com.example.accessingdatamysql.service.Service<ProductAttributeValueDTO> {
    private final ProductAttributeValueRepository repo;
    private final ProductAttributeValueMapper mapper;

    public List<ProductAttributeValueDTO> getAll() {
        List<ProductAttributeValue> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<ProductAttributeValueDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(ProductAttributeValueDTO dto) {
        try {
            ProductAttributeValue e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductAttributeValueDTO dto) {
        ProductAttributeValue e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(ProductAttributeValueDTO dto) {
        ProductAttributeValue e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
