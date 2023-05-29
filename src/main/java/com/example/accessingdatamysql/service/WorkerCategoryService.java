package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.EventWithProduct;
import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import com.example.accessingdatamysql.dao.repo.EventWithProductRepository;
import com.example.accessingdatamysql.dao.repo.WorkerCategoryRepository;
import com.example.accessingdatamysql.dto.EventWithProductDTO;
import com.example.accessingdatamysql.dto.WorkerCategoryDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.EventWithProductMapper;
import com.example.accessingdatamysql.mapper.WorkerCategoryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class WorkerCategoryService implements Service<WorkerCategoryDTO>{
    private final WorkerCategoryRepository repo;
    private final WorkerCategoryMapper mapper;

    @Override
    public List<WorkerCategoryDTO> getAll() {
        List<WorkerCategory> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<WorkerCategoryDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(WorkerCategoryDTO dto) {
        try {
            WorkerCategory e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(WorkerCategoryDTO dto) {
        WorkerCategory e = mapper.toEntity(dto);
        repo.save(e);
    }

    @Override
    public void drop(WorkerCategoryDTO dto) {
        WorkerCategory e = mapper.toEntity(dto);
        repo.delete(e);
    }
}