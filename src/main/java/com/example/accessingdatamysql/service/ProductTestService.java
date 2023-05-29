package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductTest;
import com.example.accessingdatamysql.dao.entities.ProductTest;
import com.example.accessingdatamysql.dao.repo.ProductTestRepository;
import com.example.accessingdatamysql.dto.ProductTestDTO;
import com.example.accessingdatamysql.dto.ProductTestDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductTestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ProductTestService implements Service<ProductTestDTO>{
    private final ProductTestRepository personalFunctionRepository;
    private final ProductTestMapper personalFunctionMapper;

    public List<ProductTestDTO> getAll() {
        List<ProductTest> factories = personalFunctionRepository.findAll();
        return factories.stream().map(personalFunctionMapper::toDTO).toList();
    }

    public Optional<ProductTestDTO> getById(int id) {
        return personalFunctionRepository.findById(id).map(personalFunctionMapper::toDTO);
    }

    public void add(ProductTestDTO dto) {
        try {
            ProductTest personalFunction = personalFunctionMapper.toEntity(dto);
            personalFunctionRepository.save(personalFunction);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductTestDTO dto) {
        ProductTest personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.save(personalFunction);
    }

    public void drop(ProductTestDTO dto) {
        ProductTest personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.delete(personalFunction);

    }
}
