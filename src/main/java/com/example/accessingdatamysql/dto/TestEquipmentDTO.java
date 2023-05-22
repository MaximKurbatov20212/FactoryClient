package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Equipment;
import com.example.accessingdatamysql.dao.entities.ProductTest;
import jakarta.validation.constraints.NotNull;

public class TestEquipmentDTO {
    @NotNull
    private Integer id;

    @NotNull
    private ProductTest test;

    @NotNull
    private Equipment equipment;
}
