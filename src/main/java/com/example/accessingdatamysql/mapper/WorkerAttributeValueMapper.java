package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.WorkerAttributeValue;
import com.example.accessingdatamysql.dto.WorkerAttributeValueDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkerAttributeValueMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "attribute", source = "attribute")
    WorkerAttributeValue toEntity(WorkerAttributeValueDTO workerAttributeValueDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "attribute", source = "attribute")
    WorkerAttributeValueDTO toDTO(WorkerAttributeValue workerAttributeValue);
}
