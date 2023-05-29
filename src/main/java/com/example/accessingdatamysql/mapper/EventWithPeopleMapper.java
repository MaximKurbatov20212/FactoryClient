package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.EventWithPeople;
import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)

public interface EventWithPeopleMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testEquipment", source = "testEquipment")
    EventWithPeople toEntity(EventWithPeopleDTO eventWithPeopleDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testEquipment", source = "testEquipment")
    EventWithPeopleDTO toDTO(EventWithPeople eventWithPeople);
}
