package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductionCycle;
import com.example.accessingdatamysql.dto.ProductionCycleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductionCycleMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "site", source = "site")
    @Mapping(target = "brigade", source = "brigade")
    ProductionCycle toEntity(ProductionCycleDTO productionCycleDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "site", source = "site")
    @Mapping(target = "brigade", source = "brigade")
    ProductionCycleDTO toDTO(ProductionCycle productionCycle);
}
