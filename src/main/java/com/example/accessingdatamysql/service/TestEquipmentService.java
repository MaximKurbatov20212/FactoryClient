package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.TestEquipment;
import com.example.accessingdatamysql.dao.repo.TestEquipmentRepository;
import com.example.accessingdatamysql.dto.TestEquipmentDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.TestEquipmentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class TestEquipmentService implements com.example.accessingdatamysql.service.Service<TestEquipmentDTO> {
    private final TestEquipmentRepository repo;
    private final TestEquipmentMapper mapper;

    public List<TestEquipmentDTO> getAll() {
        List<TestEquipment> e = repo.findAll();
        return e.stream().map(mapper::toDTO).toList();
    }

    public Optional<TestEquipmentDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public void add(TestEquipmentDTO dto) {
        try {
            TestEquipment e = mapper.toEntity(dto);
            repo.save(e);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    public void edit(TestEquipmentDTO dto) {
        TestEquipment e = mapper.toEntity(dto);
        repo.save(e);
    }

    public void drop(TestEquipmentDTO dto) {
        TestEquipment e = mapper.toEntity(dto);
        repo.delete(e);
    }
}
