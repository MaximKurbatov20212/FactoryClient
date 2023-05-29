package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Equipment;
import com.example.accessingdatamysql.dao.repo.EquipmentRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.exception.QueryException;
import com.example.accessingdatamysql.mapper.EquipmentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class EquipmentService implements Service<EquipmentDTO> {
    private final EquipmentRepository repo;
    private final EquipmentMapper mapper;
    @Override
    public List<EquipmentDTO> getAll() {
        List<Equipment> equipments = repo.findAll();
        return equipments.stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<EquipmentDTO> getById(int id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Override
    public void add(EquipmentDTO dto) {
        try {
            Equipment equipment = mapper.toEntity(dto);
            repo.save(equipment);
        } catch (DataAccessException e) {
            throw new QueryException("Recheck fields maybe it exists");
        }
    }

    @Override
    public void edit(EquipmentDTO dto) {
        Equipment equipment = mapper.toEntity(dto);
        repo.save(equipment);
    }

    @Override
    public void drop(EquipmentDTO dto) {
        Equipment equipment = mapper.toEntity(dto);
        repo.delete(equipment);
    }
}
