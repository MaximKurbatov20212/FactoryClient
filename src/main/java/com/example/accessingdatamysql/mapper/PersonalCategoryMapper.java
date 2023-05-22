package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import com.example.accessingdatamysql.dto.PersonalCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalCategoryMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "personalList", source = "personalList")
    @Mapping(target = "personalCategoryAttributes", source = "personalCategoryAttributes")
    PersonalCategory toEntity(PersonalCategoryDTO personalCategoryDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "personalList", source = "personalList")
    @Mapping(target = "personalCategoryAttributes", source = "personalCategoryAttributes")
    PersonalCategoryDTO toDTO(PersonalCategory personalCategory);
}
