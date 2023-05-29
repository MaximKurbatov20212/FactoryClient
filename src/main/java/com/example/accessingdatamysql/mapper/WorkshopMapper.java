package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Workshop;
import com.example.accessingdatamysql.dto.WorkshopDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkshopMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "factory", source = "factory")
    @Mapping(target = "director", source = "director")
    @Mapping(target = "sites", source = "sites")
    @Mapping(target = "products", source = "products")
    Workshop toEntity(WorkshopDTO workshopDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "factory", source = "factory")
    @Mapping(target = "director", source = "director")
    @Mapping(target = "sites", source = "sites")
    @Mapping(target = "products", source = "products")
    WorkshopDTO toDTO(Workshop workshop);
}
