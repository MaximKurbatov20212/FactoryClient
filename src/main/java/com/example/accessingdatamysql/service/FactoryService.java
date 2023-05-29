package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Factory;
import com.example.accessingdatamysql.dao.repo.FactoryRepository;
import com.example.accessingdatamysql.dto.FactoryDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.FactoryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class FactoryService implements com.example.accessingdatamysql.service.Service<FactoryDTO> {
    private final FactoryRepository factoryRepository;
    private final FactoryMapper factoryMapper;

    public List<FactoryDTO> getAll() {
        List<Factory> e = factoryRepository.findAll();
        return e.stream().map(factoryMapper::toDTO).toList();
    }

    public Optional<FactoryDTO> getById(int id) {
        return factoryRepository.findById(id).map(factoryMapper::toDTO);
    }

    public void add(FactoryDTO dto) {
        try {
            Factory e = factoryMapper.toEntity(dto);
            factoryRepository.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(FactoryDTO dto) {
        Factory e = factoryMapper.toEntity(dto);
        factoryRepository.save(e);
    }

    public void drop(FactoryDTO dto) {
        Factory e = factoryMapper.toEntity(dto);
        factoryRepository.delete(e);
    }
}
