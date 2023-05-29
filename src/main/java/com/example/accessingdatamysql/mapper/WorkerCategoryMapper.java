package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import com.example.accessingdatamysql.dto.WorkerCategoryAttributeDTO;
import com.example.accessingdatamysql.dto.WorkerCategoryDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkerCategoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "products", source = "testEquipment")
    @Mapping(target = "productCategoryAttributes", source = "productCategoryAttributes")
    WorkerCategory toEntity(WorkerCategoryDTO workerCategoryDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "products", source = "testEquipment")
    @Mapping(target = "productCategoryAttributes", source = "productCategoryAttributes")
    WorkerCategoryDTO toDTO(WorkerCategory workerCategory);
}
