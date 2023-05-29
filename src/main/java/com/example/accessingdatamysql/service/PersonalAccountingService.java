package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.PersonalAccounting;
import com.example.accessingdatamysql.dao.repo.PersonalAccountingRepository;
import com.example.accessingdatamysql.dto.PersonalAccountingDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.PersonalAccountingMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PersonalAccountingService implements com.example.accessingdatamysql.service.Service<PersonalAccountingDTO> {
    private final PersonalAccountingRepository repo;
    private final PersonalAccountingMapper mapper;

    public List<PersonalAccountingDTO> getAll() {
        List<PersonalAccounting> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<PersonalAccountingDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(PersonalAccountingDTO dto) {
        try {
            PersonalAccounting e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(PersonalAccountingDTO dto) {
        PersonalAccounting e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(PersonalAccountingDTO dto) {
        PersonalAccounting e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
