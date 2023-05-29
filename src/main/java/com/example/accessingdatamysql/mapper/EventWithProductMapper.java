package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.EventWithProduct;
import com.example.accessingdatamysql.dto.EventWithProductDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)

public interface EventWithProductMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testProduct", source = "testEquipment")
    EventWithProduct toEntity(EventWithProductDTO eventWithProductDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testEquipment", source = "testEquipment")
    EventWithProductDTO toDTO(EventWithProduct eventWithProduct);
}
