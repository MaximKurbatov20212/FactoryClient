package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Workshop;
import com.example.accessingdatamysql.dao.repo.WorkshopRepository;
import com.example.accessingdatamysql.dto.WorkshopDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.WorkshopMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class WorkshopService implements com.example.accessingdatamysql.service.Service<WorkshopDTO> {
    private final WorkshopRepository repo;
    private final WorkshopMapper mapper;

    public List<WorkshopDTO> getAll() {
        List<Workshop> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<WorkshopDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(WorkshopDTO dto) {
        try {
            Workshop e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(WorkshopDTO dto) {
        Workshop e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(WorkshopDTO dto) {
        Workshop e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
