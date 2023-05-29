package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductAccounting;
import com.example.accessingdatamysql.dao.repo.ProductAccountingRepository;
import com.example.accessingdatamysql.dto.ProductAccountingDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductAccountingMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductAccountingService implements com.example.accessingdatamysql.service.Service<ProductAccountingDTO> {
    private final ProductAccountingRepository repo;
    private final ProductAccountingMapper mapper;

    public List<ProductAccountingDTO> getAll() {
        List<ProductAccounting> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<ProductAccountingDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(ProductAccountingDTO dto) {
        try {
            ProductAccounting e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductAccountingDTO dto) {
        ProductAccounting e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(ProductAccountingDTO dto) {
        ProductAccounting e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
