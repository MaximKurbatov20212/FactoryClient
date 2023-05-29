package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Worker;
import com.example.accessingdatamysql.dto.WorkerDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
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
