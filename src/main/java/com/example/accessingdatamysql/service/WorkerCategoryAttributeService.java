package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.WorkerCategoryAttribute;
import com.example.accessingdatamysql.dao.repo.WorkerCategoryAttributeRepository;
import com.example.accessingdatamysql.dto.WorkerCategoryAttributeDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.WorkerCategoryAttributeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class WorkerCategoryAttributeService implements com.example.accessingdatamysql.service.Service<WorkerCategoryAttributeDTO> {
    private final WorkerCategoryAttributeRepository repo;
    private final WorkerCategoryAttributeMapper mapper;

    public List<WorkerCategoryAttributeDTO> getAll() {
        List<WorkerCategoryAttribute> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<WorkerCategoryAttributeDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(WorkerCategoryAttributeDTO dto) {
        try {
            WorkerCategoryAttribute e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(WorkerCategoryAttributeDTO dto) {
        WorkerCategoryAttribute e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(WorkerCategoryAttributeDTO dto) {
        WorkerCategoryAttribute e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
