package com.example.accessingdatamysql.service;


import com.example.accessingdatamysql.dao.entities.Site;
import com.example.accessingdatamysql.dao.repo.SiteRepository;
import com.example.accessingdatamysql.dto.SiteDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.SiteMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class SiteService implements com.example.accessingdatamysql.service.Service<SiteDTO> {
    private final SiteRepository repo;
    private final SiteMapper mapper;

    public List<SiteDTO> getAll() {
        List<Site> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<SiteDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(SiteDTO dto) {
        try {
            Site e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(SiteDTO dto) {
        Site e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(SiteDTO dto) {
        Site e = mapper.toEntity(dto);
        repo.delete(e);
    }
}