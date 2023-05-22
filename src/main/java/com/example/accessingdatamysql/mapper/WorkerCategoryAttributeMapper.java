package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.WorkerAttributeValue;
import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import com.example.accessingdatamysql.dao.entities.WorkerCategoryAttribute;
import com.example.accessingdatamysql.dto.WorkerCategoryAttributeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkerCategoryAttributeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "workerAttributeValues", source = "workerAttributeValues")
    WorkerCategoryAttribute toEntity(WorkerCategoryAttributeDTO workerCategoryAttributeDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "workerAttributeValues", source = "workerAttributeValues")
    WorkerCategoryAttributeDTO toDTO(WorkerCategoryAttributeDTO workerCategoryAttributeDTO);
}
