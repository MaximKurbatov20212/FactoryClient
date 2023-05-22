package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductType;
import com.example.accessingdatamysql.dto.ProductTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "products", source = "products")
    ProductType toEntity(ProductTypeDTO productTypeDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "products", source = "products")
    ProductTypeDTO toDTO(ProductType productType);
}
