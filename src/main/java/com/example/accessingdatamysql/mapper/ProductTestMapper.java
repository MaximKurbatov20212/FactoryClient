package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductTest;
import com.example.accessingdatamysql.dto.ProductTestDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductTestMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "laboratory", source = "laboratory")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "testEquipments", source = "testEquipments")
    @Mapping(target = "expertTests", source = "expertTests")
    ProductTest toEntity(ProductTestDTO productTestDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "laboratory", source = "laboratory")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "testEquipments", source = "testEquipments")
    @Mapping(target = "expertTests", source = "expertTests")
    ProductTestDTO toDTO(ProductTest productTest);
}
