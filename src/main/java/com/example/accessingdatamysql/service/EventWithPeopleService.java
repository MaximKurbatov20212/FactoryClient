package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.EventWithPeople;
import com.example.accessingdatamysql.dao.repo.EventWithPeopleRepository;
import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.EventWithPeopleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class EventWithPeopleService implements Service<EventWithPeopleDTO>{
    private final EventWithPeopleRepository repo;
    private final EventWithPeopleMapper mapper;
    @Override
    public List<EventWithPeopleDTO> getAll() {
        List<EventWithPeople> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<EventWithPeopleDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(EventWithPeopleDTO dto) {
        try {
            EventWithPeople e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(EventWithPeopleDTO dto) {
        EventWithPeople e = mapper.toEntity(dto);
        repo.save(e);
    }

    @Override
    public void drop(EventWithPeopleDTO dto) {
        EventWithPeople e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
