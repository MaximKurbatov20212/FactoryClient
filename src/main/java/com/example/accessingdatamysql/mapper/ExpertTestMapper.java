package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import com.example.accessingdatamysql.dto.ExpertTestDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
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
