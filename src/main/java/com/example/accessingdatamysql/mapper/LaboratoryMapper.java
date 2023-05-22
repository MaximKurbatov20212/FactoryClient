package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Laboratory;
import com.example.accessingdatamysql.dto.LaboratoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LaboratoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productTests", source = "productTests")
    Laboratory toEntity(LaboratoryDTO laboratoryDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productTests", source = "productTests")
    LaboratoryDTO toDTO(Laboratory laboratory);
}
