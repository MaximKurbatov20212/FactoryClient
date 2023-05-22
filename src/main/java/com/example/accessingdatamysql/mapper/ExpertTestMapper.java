package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import com.example.accessingdatamysql.dto.ExpertTestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpertTestMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "test", source = "test")
    @Mapping(target = "expert", source = "expert")
    ExpertTest toEntity(ExpertTestDTO expertTestDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "test", source = "test")
    @Mapping(target = "expert", source = "expert")
    ExpertTestDTO toDTO(ExpertTest expertTest);
}
