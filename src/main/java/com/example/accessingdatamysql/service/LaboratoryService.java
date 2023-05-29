package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Factory;
import com.example.accessingdatamysql.dao.entities.Laboratory;
import com.example.accessingdatamysql.dao.repo.FactoryRepository;
import com.example.accessingdatamysql.dao.repo.LaboratoryRepository;
import com.example.accessingdatamysql.dto.LaboratoryDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.FactoryMapper;
import com.example.accessingdatamysql.mapper.LaboratoryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
@Service
@AllArgsConstructor
public class LaboratoryService implements com.example.accessingdatamysql.service.Service<LaboratoryDTO> {

    private final LaboratoryRepository repo;
    private final LaboratoryMapper mapper;
    @Override
    public List<LaboratoryDTO> getAll() {
        List<Laboratory> laboratories = repo.findAll();
        return laboratories.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<LaboratoryDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(LaboratoryDTO dto) {
        try {
            Laboratory laboratory = mapper.toEntity(dto);
            repo.save(laboratory);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(LaboratoryDTO dto) {
        Laboratory laboratory = mapper.toEntity(dto);
        repo.save(laboratory);
    }

    @Override
    public void drop(LaboratoryDTO dto) {
        Laboratory laboratory = mapper.toEntity(dto);
        repo.delete(laboratory);
    }
}
