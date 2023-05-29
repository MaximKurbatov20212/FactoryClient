package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import com.example.accessingdatamysql.dao.repo.PersonalCategoryRepository;
import com.example.accessingdatamysql.dto.PersonalCategoryDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.PersonalCategoryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class PersonalCategoryService implements Service<PersonalCategoryDTO> {
    private final PersonalCategoryRepository repo;
    private final PersonalCategoryMapper mapper;

    @Override
    public List<PersonalCategoryDTO> getAll() {
        List<PersonalCategory> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<PersonalCategoryDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(PersonalCategoryDTO dto) {
        try {
            PersonalCategory e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(PersonalCategoryDTO dto) {
        PersonalCategory e = mapper.toEntity(dto);
        repo.save(e);
    }

    @Override
    public void drop(PersonalCategoryDTO dto) {
        PersonalCategory e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
