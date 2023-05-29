package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.WorkerAccounting;
import com.example.accessingdatamysql.dto.WorkerAccountingDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkerAccountingMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "event", source = "event")
    WorkerAccounting toEntity(WorkerAccountingDTO workerAccountingDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "event", source = "event")
    WorkerAccountingDTO toDTO(WorkerAccounting workerAccounting);
}
