package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.TestEquipment;
import com.example.accessingdatamysql.dto.TestEquipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
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
