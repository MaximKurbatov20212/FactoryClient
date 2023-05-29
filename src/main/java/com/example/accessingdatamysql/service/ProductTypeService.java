package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ProductType;
import com.example.accessingdatamysql.dao.repo.ProductTypeRepository;
import com.example.accessingdatamysql.dto.ProductTypeDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ProductTypeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ProductTypeService implements Service<ProductTypeDTO> {
    private final ProductTypeRepository personalFunctionRepository;
    private final ProductTypeMapper personalFunctionMapper;

    public List<ProductTypeDTO> getAll() {
        List<ProductType> factories = personalFunctionRepository.findAll();
        return factories.stream().map(personalFunctionMapper::toDTO).toList();
    }

    public Optional<ProductTypeDTO> getById(int id) {
        return personalFunctionRepository.findById(id).map(personalFunctionMapper::toDTO);
    }

    public void add(ProductTypeDTO dto) {
        try {
            ProductType personalFunction = personalFunctionMapper.toEntity(dto);
            personalFunctionRepository.save(personalFunction);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ProductTypeDTO dto) {
        ProductType personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.save(personalFunction);
    }

    public void drop(ProductTypeDTO dto) {
        ProductType personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.delete(personalFunction);

    }
}

