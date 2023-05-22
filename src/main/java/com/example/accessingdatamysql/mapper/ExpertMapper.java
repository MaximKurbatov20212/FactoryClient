package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Expert;
import com.example.accessingdatamysql.dto.ExpertDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpertMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "expertTests", source = "expertTests")
    Expert toEntity(ExpertDTO expertDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "expertTests", source = "expertTests")
    ExpertDTO toDTO(Expert expert);
}
