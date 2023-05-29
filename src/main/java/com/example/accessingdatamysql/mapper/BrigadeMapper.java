package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)

public interface BrigadeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "site", source = "site")
    Brigade toEntity(BrigadeDTO brigadeDTO);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "site", source = "site")
    BrigadeDTO toDTO(Brigade brigade);
}
