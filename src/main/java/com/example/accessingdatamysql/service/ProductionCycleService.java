package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductionCycle;
import com.example.accessingdatamysql.dao.repo.ProductionCycleRepository;
import com.example.accessingdatamysql.dto.ProductionCycleDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductionCycleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductionCycleService implements com.example.accessingdatamysql.service.Service<ProductionCycleDTO> {
    private final ProductionCycleRepository repo;
    private final ProductionCycleMapper mapper;

    public List<ProductionCycleDTO> getAll() {
        List<ProductionCycle> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<ProductionCycleDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(ProductionCycleDTO dto) {
        try {
            ProductionCycle e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductionCycleDTO dto) {
        ProductionCycle e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(ProductionCycleDTO dto) {
        ProductionCycle e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
