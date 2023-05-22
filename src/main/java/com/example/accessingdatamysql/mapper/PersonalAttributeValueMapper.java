package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dto.PersonalAttributeValueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalAttributeValueMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "attribute", source = "attribute")
    @Mapping(target = "person", source = "person")
    PersonalAttributeValue toEntity(PersonalAttributeValueDTO personalAttributeValueDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "attribute", source = "attribute")
    @Mapping(target = "person", source = "person")
    PersonalAttributeValueDTO toDTO(PersonalAttributeValue personalAttributeValue);
}
