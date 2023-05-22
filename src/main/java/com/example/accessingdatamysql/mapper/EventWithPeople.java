package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Equipment;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import org.mapstruct.Mapping;

public interface EventWithPeople {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testEquipment", source = "testEquipment")
    EventWithPeople toEventWithPeopleEntity(EventWithPeopleDTO eventWithPeopleDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testEquipment", source = "testEquipment")
    EventWithPeopleDTO toEventWithPeopleDTO(EventWithPeople eventWithPeople);
}
