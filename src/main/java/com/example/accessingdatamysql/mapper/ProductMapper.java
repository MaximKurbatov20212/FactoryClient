package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "workshop", source = "workshop")
    @Mapping(target = "productionCycles", source = "productionCycles")
    @Mapping(target = "productionAttributeValues", source = "productionAttributeValues")
    Product toEntity(ProductDTO productDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "workshop", source = "workshop")
    @Mapping(target = "productionCycles", source = "productionCycles")
    @Mapping(target = "productionAttributeValues", source = "productionAttributeValues")
    ProductDTO toDTO(Product product);
}
