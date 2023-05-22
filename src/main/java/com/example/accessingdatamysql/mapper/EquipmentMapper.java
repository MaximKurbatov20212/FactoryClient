package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Equipment;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productAccountingList", source = "productAccountingList")
    Equipment toEquipmentEntity(EquipmentDTO equipmentDTO);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productAccountingList", source = "productAccountingList")
    EquipmentDTO toEquipmentDTO(Equipment equipment);
}
