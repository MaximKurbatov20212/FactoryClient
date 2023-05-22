package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dto.EventWithProductDTO;
import org.mapstruct.Mapping;

public interface EventWithProduct {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testProduct", source = "testEquipment")
    EventWithProduct toEventWithProductEntity(EventWithProductDTO eventWithProductDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "testEquipment", source = "testEquipment")
    EventWithProductDTO toEventWithProductDTO(EventWithProduct eventWithProduct);
}
