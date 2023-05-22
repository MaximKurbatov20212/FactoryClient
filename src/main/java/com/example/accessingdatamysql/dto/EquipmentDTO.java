package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.TestEquipment;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EquipmentDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String name;

    @NotNull
    List<TestEquipment> testEquipments = new ArrayList<>();
}
