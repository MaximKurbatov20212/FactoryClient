package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import com.example.accessingdatamysql.dao.repo.ExpertTestRepository;
import com.example.accessingdatamysql.dto.ExpertTestDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ExpertTestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ExpertTestService implements com.example.accessingdatamysql.service.Service<ExpertTestDTO> {
    private final ExpertTestRepository repo;
    private final ExpertTestMapper mapper;

    public List<ExpertTestDTO> getAll() {
        List<ExpertTest> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<ExpertTestDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(ExpertTestDTO dto) {
        try {
            ExpertTest e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(ExpertTestDTO dto) {
        ExpertTest e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(ExpertTestDTO dto) {
        ExpertTest e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
