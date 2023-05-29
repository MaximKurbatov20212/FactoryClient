package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.*;
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

public class ProductDTO {

    @NotNull
    private Integer id;

    @NotNull
    private ProductTypeDTO type;

    @NotNull
    private ProductCategoryDTO category;

    @NotNull
    private WorkshopDTO workshop;

    @NotNull
    List<ProductionCycleDTO> productionCycles = new ArrayList<>();

    @NotNull
    List<ProductAttributeValueDTO> personalAttributeValues = new ArrayList<>();
}
