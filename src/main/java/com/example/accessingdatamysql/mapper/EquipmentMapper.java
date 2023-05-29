package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Equipment;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EquipmentMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productAccountingList", source = "productAccountingList")
    Equipment toEntity(EquipmentDTO equipmentDTO);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productAccountingList", source = "productAccountingList")
    EquipmentDTO toDTO(Equipment equipment);
}
