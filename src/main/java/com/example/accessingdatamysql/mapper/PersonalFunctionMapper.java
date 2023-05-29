package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.PersonalFunction;
import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PersonalFunctionMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "personalList", source = "personalList")
    PersonalFunction toEntity(PersonalFunctionDTO personalFunctionDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "personalList", source = "personalList")
    PersonalFunctionDTO toDTO(PersonalFunction personalFunction);
}
