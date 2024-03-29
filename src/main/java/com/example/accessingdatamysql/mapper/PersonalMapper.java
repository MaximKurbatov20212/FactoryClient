package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dto.PersonalDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PersonalMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "function", source = "function")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "workshops", source = "workshops")
    @Mapping(target = "testProduct", source = "testEquipment")
    @Mapping(target = "personalAttributeValues", source = "personalAttributeValues")
    Personal toEntity(PersonalDTO personalDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "function", source = "function")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "workshops", source = "workshops")
    @Mapping(target = "testProduct", source = "testEquipment")
    @Mapping(target = "personalAttributeValues", source = "personalAttributeValues")
    PersonalDTO toDTO(Personal personal);
}