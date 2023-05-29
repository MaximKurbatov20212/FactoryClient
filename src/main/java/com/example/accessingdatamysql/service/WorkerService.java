package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Worker;
import com.example.accessingdatamysql.dao.repo.WorkerRepository;
import com.example.accessingdatamysql.dto.WorkerDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.WorkerMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class WorkerService implements com.example.accessingdatamysql.service.Service<WorkerDTO> {
    private final WorkerRepository repo;
    private final WorkerMapper mapper;

    public List<WorkerDTO> getAll() {
        List<Worker> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<WorkerDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(WorkerDTO dto) {
        try {
            Worker e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(WorkerDTO dto) {
        Worker e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(WorkerDTO dto) {
        Worker e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
