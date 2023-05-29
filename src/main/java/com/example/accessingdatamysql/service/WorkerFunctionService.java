package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.WorkerFunction;
import com.example.accessingdatamysql.dao.repo.WorkerFunctionRepository;
import com.example.accessingdatamysql.dto.WorkerFunctionDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.WorkerFunctionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class WorkerFunctionService implements Service<WorkerFunctionDTO> {
    private final WorkerFunctionRepository personalFunctionRepository;
    private final WorkerFunctionMapper personalFunctionMapper;

    public List<WorkerFunctionDTO> getAll() {
        List<WorkerFunction> factories = personalFunctionRepository.findAll();
        return factories.stream().map(personalFunctionMapper::toDTO).toList();
    }

    public Optional<WorkerFunctionDTO> getById(int id) {
        return personalFunctionRepository.findById(id).map(personalFunctionMapper::toDTO);
    }

    public void add(WorkerFunctionDTO dto) {
        try {
            WorkerFunction personalFunction = personalFunctionMapper.toEntity(dto);
            personalFunctionRepository.save(personalFunction);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(WorkerFunctionDTO dto) {
        WorkerFunction personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.save(personalFunction);
    }

    public void drop(WorkerFunctionDTO dto) {
        WorkerFunction personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.delete(personalFunction);

    }
}
