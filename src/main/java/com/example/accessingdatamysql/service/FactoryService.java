package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.entities.Factory;
import com.example.accessingdatamysql.dao.entities.Workshop;
import com.example.accessingdatamysql.dao.repo.FactoryRepository;
import com.example.accessingdatamysql.dto.FactoryDTO;
import com.example.accessingdatamysql.mapper.FactoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FactoryService {
    private final FactoryMapper factoryMapper;
    private final FactoryRepository factoryRepository;

    public List<FactoryDTO> getFactories() {
        List<Factory> factories = factoryRepository.findAll();
        return factories.stream().map(factoryMapper::toDTO).toList();
    }
}
