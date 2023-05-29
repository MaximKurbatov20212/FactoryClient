package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import com.example.accessingdatamysql.dao.entities.Laboratory;
import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.TestEquipment;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTestDTO {

    @NotNull
    private Integer id;
    @NotNull
    private LaboratoryDTO laboratory;
    @NotNull
    private ProductDTO product;
    @NotNull
    List<TestEquipmentDTO> testEquipments = new ArrayList<>();
    @NotNull
    List<ExpertTestDTO> expertTests = new ArrayList<>();
}
