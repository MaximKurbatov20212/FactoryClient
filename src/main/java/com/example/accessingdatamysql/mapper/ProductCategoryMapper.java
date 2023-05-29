package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductCategory;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductCategoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "products", source = "products")
    @Mapping(target = "productCategoryAttributes", source = "productCategoryAttributes")
    ProductCategory toEntity(ProductCategoryDTO productCategoryDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "products", source = "products")
    @Mapping(target = "productCategoryAttributes", source = "productCategoryAttributes")
    ProductCategoryDTO toDTO(ProductCategory productCategory);
}
