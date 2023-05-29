package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.PersonalFunction;
import com.example.accessingdatamysql.dao.repo.PersonalFunctionRepository;
import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.PersonalFunctionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class PersonalFunctionService implements Service<PersonalFunctionDTO> {
    private final PersonalFunctionRepository personalFunctionRepository;
    private final PersonalFunctionMapper personalFunctionMapper;

    public List<PersonalFunctionDTO> getAll() {
        List<PersonalFunction> factories = personalFunctionRepository.findAll();
        return factories.stream().map(personalFunctionMapper::toDTO).toList();
    }

    public Optional<PersonalFunctionDTO> getById(int id) {
        return personalFunctionRepository.findById(id).map(personalFunctionMapper::toDTO);
    }

    public void add(PersonalFunctionDTO dto) {
        try {
            PersonalFunction personalFunction = personalFunctionMapper.toEntity(dto);
            personalFunctionRepository.save(personalFunction);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(PersonalFunctionDTO dto) {
        PersonalFunction personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.save(personalFunction);
    }

    public void drop(PersonalFunctionDTO dto) {
        PersonalFunction personalFunction = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.delete(personalFunction);

    }
}