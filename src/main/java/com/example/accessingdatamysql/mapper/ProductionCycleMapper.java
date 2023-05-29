package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductionCycle;
import com.example.accessingdatamysql.dto.ProductionCycleDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
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
