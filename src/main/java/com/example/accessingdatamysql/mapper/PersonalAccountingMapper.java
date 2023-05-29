package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.PersonalAccounting;
import com.example.accessingdatamysql.dto.PersonalAccountingDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PersonalAccountingMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "event", source = "event")
    PersonalAccounting toEntity(PersonalAccountingDTO workerAccountingDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "event", source = "event")
    PersonalAccountingDTO toDTO(PersonalAccounting workerAccounting);
}
