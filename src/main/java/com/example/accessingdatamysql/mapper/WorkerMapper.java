package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Worker;
import com.example.accessingdatamysql.dto.WorkerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "brigade", source = "brigade")
    @Mapping(target = "function", source = "function")
    @Mapping(target = "category", source = "category")
    Worker toEntity(WorkerDTO workerDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "brigade", source = "brigade")
    @Mapping(target = "function", source = "function")
    @Mapping(target = "category", source = "category")
    WorkerDTO toDTO(Worker worker);
}
