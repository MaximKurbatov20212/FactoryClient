package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductAttributeValue;
import com.example.accessingdatamysql.dto.ProductAttributeValueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductAttributeValueMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "attribute", source = "attribute")
    ProductAttributeValue toEntity(ProductAttributeValueDTO productAttributeValueDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "attribute", source = "attribute")
    ProductAttributeValueDTO toDTO(ProductAttributeValue productAttributeValue);
}
