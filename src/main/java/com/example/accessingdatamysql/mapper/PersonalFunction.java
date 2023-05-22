package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalFunction {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "personalList", source = "personalList")
    PersonalFunction toEntity(PersonalFunctionDTO personalFunctionDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "personalList", source = "personalList")
    PersonalFunctionDTO toDTO(PersonalFunction personalFunction);
}
