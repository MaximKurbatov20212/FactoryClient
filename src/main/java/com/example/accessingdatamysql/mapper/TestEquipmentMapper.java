package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.TestEquipment;
import com.example.accessingdatamysql.dto.TestEquipmentDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TestEquipmentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "test", source = "test")
    @Mapping(target = "equipment", source = "equipment")
    TestEquipment toEntity(TestEquipmentDTO testEquipmentDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "test", source = "test")
    @Mapping(target = "equipment", source = "equipment")
    TestEquipmentDTO toDTO(TestEquipment testEquipment);
}
