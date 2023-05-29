package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Expert;
import com.example.accessingdatamysql.dao.repo.ExpertRepository;
import com.example.accessingdatamysql.dto.ExpertDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.ExpertMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ExpertService implements Service<ExpertDTO> {
    private final ExpertRepository repo;
    private final ExpertMapper mapper;
    @Override
    public List<ExpertDTO> getAll() {
        List<Expert> experts = repo.findAll();
        return experts.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<ExpertDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(ExpertDTO dto) {
        try {
            Expert expert = mapper.toEntity(dto);
            repo.save(expert);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(ExpertDTO dto) {
        Expert expert = mapper.toEntity(dto);
        repo.save(expert);
    }

    @Override
    public void drop(ExpertDTO dto) {
        Expert expert = mapper.toEntity(dto);
        repo.delete(expert);
    }
}
