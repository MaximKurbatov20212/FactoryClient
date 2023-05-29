package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Equipment;
import com.example.accessingdatamysql.dao.entities.ProductTest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class TestEquipmentDTO {
    @NotNull
    private Integer id;

    @NotNull
    private ProductTestDTO test;

    @NotNull
    private EquipmentDTO equipment;
}
