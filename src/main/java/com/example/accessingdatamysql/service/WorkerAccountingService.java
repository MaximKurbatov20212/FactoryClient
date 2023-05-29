package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.WorkerAccounting;
import com.example.accessingdatamysql.dao.repo.WorkerAccountingRepository;
import com.example.accessingdatamysql.dto.WorkerAccountingDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.WorkerAccountingMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class WorkerAccountingService implements com.example.accessingdatamysql.service.Service<WorkerAccountingDTO> {
    private final WorkerAccountingRepository repo;
    private final WorkerAccountingMapper mapper;

    public List<WorkerAccountingDTO> getAll() {
        List<WorkerAccounting> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<WorkerAccountingDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(WorkerAccountingDTO dto) {
        try {
            WorkerAccounting e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(WorkerAccountingDTO dto) {
        WorkerAccounting e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(WorkerAccountingDTO dto) {
        WorkerAccounting e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
