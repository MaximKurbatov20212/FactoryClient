package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import com.example.accessingdatamysql.dto.PersonalAttributeValueDTO;
import com.example.accessingdatamysql.dto.PersonalCategoryAttributeDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PersonalCategoryAttributeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "personalAttributeValues", source = "personalAttributeValues")
    PersonalCategoryAttribute toEntity(PersonalCategoryAttributeDTO p);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "personalAttributeValues", source = "personalAttributeValues")
    PersonalCategoryAttributeDTO toDTO(PersonalCategoryAttribute p);
}
