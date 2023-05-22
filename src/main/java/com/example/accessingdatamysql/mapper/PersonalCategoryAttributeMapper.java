package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dto.PersonalAttributeValueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalCategoryAttributeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "attributeName", source = "attributeName")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "personalAttributeValues", source = "personalAttributeValues")
    PersonalAttributeValue toEntity(PersonalAttributeValueDTO personalAttributeValueDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "attributeName", source = "attributeName")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "personalAttributeValues", source = "personalAttributeValues")
    PersonalAttributeValueDTO toDTO(PersonalAttributeValue personalAttributeValue);
}
