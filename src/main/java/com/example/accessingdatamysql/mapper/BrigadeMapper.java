package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrigadeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "site", source = "site")
    Brigade toBrigadeEntity(BrigadeDTO brigadeDTO);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "site", source = "site")
    BrigadeDTO toBrigadeDTO(Brigade brigade);
}
