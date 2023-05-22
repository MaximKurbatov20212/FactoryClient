package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductTest;
import com.example.accessingdatamysql.dto.ProductTestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
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
