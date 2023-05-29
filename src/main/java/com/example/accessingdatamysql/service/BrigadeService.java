package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.repo.BrigadeRepository;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.BrigadeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BrigadeService implements com.example.accessingdatamysql.service.Service<BrigadeDTO> {
    private final BrigadeRepository repo;
    private final BrigadeMapper mapper;

    public List<BrigadeDTO> getAll() {
        List<Brigade> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<BrigadeDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(BrigadeDTO dto) {
        try {
            Brigade e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(BrigadeDTO dto) {
        Brigade e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(BrigadeDTO dto) {
        Brigade e = mapper.toEntity(dto);
        repo.delete(e);
    }
}

