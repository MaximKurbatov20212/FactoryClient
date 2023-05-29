
package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.repo.PersonalRepository;
import com.example.accessingdatamysql.dto.PersonalDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.PersonalMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class PersonalService implements Service<PersonalDTO> {
    private final PersonalRepository personalFunctionRepository;
    private final PersonalMapper personalFunctionMapper;

    public List<PersonalDTO> getAll() {
        List<Personal> e = personalFunctionRepository.findAll();
        return e.stream().map(personalFunctionMapper::toDTO).toList();
    }

    public Optional<PersonalDTO> getById(int id) {
        return personalFunctionRepository.findById(id).map(personalFunctionMapper::toDTO);
    }

    public void add(PersonalDTO dto) {
        try {
            Personal e = personalFunctionMapper.toEntity(dto);
            personalFunctionRepository.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(PersonalDTO dto) {
        Personal e = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.save(e);
    }

    public void drop(PersonalDTO dto) {
        Personal e = personalFunctionMapper.toEntity(dto);
        personalFunctionRepository.delete(e);
    }
}
