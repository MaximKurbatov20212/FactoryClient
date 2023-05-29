package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import com.example.accessingdatamysql.dto.ProductAttributeValueDTO;
import com.example.accessingdatamysql.dto.ProductCategoryAttributeDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductCategoryAttributeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "attributeName", source = "attributeName")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "productAttributeValues", source = "productAttributeValues")
    ProductCategoryAttribute toEntity(ProductCategoryAttributeDTO productCategoryAttributeDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "attributeName", source = "attributeName")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "productAttributeValues", source = "productAttributeValues")
    ProductCategoryAttributeDTO toDTO(ProductCategoryAttribute productCategoryAttribute);
}
