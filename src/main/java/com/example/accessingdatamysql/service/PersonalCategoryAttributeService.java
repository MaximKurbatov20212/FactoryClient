package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import com.example.accessingdatamysql.dao.repo.PersonalCategoryAttributeRepository;
import com.example.accessingdatamysql.dto.PersonalCategoryAttributeDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.PersonalCategoryAttributeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PersonalCategoryAttributeService implements com.example.accessingdatamysql.service.Service<PersonalCategoryAttributeDTO> {
    private final PersonalCategoryAttributeRepository repo;
    private final PersonalCategoryAttributeMapper mapper;

    public List<PersonalCategoryAttributeDTO> getAll() {
        List<PersonalCategoryAttribute> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<PersonalCategoryAttributeDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(PersonalCategoryAttributeDTO dto) {
        try {
            PersonalCategoryAttribute e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(PersonalCategoryAttributeDTO dto) {
        PersonalCategoryAttribute e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(PersonalCategoryAttributeDTO dto) {
        PersonalCategoryAttribute e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
