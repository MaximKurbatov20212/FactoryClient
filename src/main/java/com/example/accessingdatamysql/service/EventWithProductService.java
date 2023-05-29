package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.EventWithProduct;
import com.example.accessingdatamysql.dao.repo.EventWithProductRepository;
import com.example.accessingdatamysql.dto.EventWithProductDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.EventWithProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class EventWithProductService implements Service<EventWithProductDTO> {
    private final EventWithProductRepository repo;
    private final EventWithProductMapper mapper;

    @Override
    public List<EventWithProductDTO> getAll() {
        List<EventWithProduct> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<EventWithProductDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(EventWithProductDTO dto) {
        try {
            EventWithProduct e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(EventWithProductDTO dto) {
        EventWithProduct e = mapper.toEntity(dto);
        repo.save(e);
    }

    @Override
    public void drop(EventWithProductDTO dto) {
        EventWithProduct e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
