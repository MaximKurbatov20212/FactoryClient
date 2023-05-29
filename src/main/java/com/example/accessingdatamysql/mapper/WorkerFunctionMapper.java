package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.WorkerFunction;
import com.example.accessingdatamysql.dto.WorkerFunctionDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkerFunctionMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "workers", source = "workers")
    WorkerFunction toEntity(WorkerFunctionDTO workerFunctionDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "workers", source = "workers")
    WorkerFunctionDTO toDTO(WorkerFunction workerFunction);
}
