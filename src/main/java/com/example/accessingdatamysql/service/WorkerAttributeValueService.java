package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.WorkerAttributeValue;
import com.example.accessingdatamysql.dao.repo.WorkerAttributeValueRepository;
import com.example.accessingdatamysql.dto.WorkerAttributeValueDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.WorkerAttributeValueMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class WorkerAttributeValueService implements com.example.accessingdatamysql.service.Service<WorkerAttributeValueDTO> {
    private final WorkerAttributeValueRepository repo;
    private final WorkerAttributeValueMapper mapper;

    public List<WorkerAttributeValueDTO> getAll() {
        List<WorkerAttributeValue> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<WorkerAttributeValueDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(WorkerAttributeValueDTO dto) {
        try {
            WorkerAttributeValue e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(WorkerAttributeValueDTO dto) {
        WorkerAttributeValue e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(WorkerAttributeValueDTO dto) {
        WorkerAttributeValue e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
