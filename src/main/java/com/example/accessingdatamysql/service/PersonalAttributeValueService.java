package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.repo.PersonalAttributeValueRepository;
import com.example.accessingdatamysql.dto.PersonalAttributeValueDTO;
import com.example.accessingdatamysql.dto.PersonalAttributeValueDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.PersonalAttributeValueMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class PersonalAttributeValueService implements Service<PersonalAttributeValueDTO> {
    private final PersonalAttributeValueRepository repo;
    private final PersonalAttributeValueMapper mapper;

    @Override
    public List<PersonalAttributeValueDTO> getAll() {
        List<PersonalAttributeValue> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<PersonalAttributeValueDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(PersonalAttributeValueDTO dto) {
        try {
            PersonalAttributeValue e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(PersonalAttributeValueDTO dto) {
        PersonalAttributeValue e = mapper.toEntity(dto);
        repo.save(e);
    }

    @Override
    public void drop(PersonalAttributeValueDTO dto) {
        PersonalAttributeValue e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
