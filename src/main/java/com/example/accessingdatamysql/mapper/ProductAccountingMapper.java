package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.ProductAccounting;
import com.example.accessingdatamysql.dto.ProductAccountingDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductAccountingMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "event", source = "event")
    ProductAccounting toEntity(ProductAccountingDTO productAccountingDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "event", source = "event")
    ProductAccountingDTO toDTO(ProductAccounting productAccounting);
}
