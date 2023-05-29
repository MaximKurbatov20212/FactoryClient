package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ProductAttributeValue;
import com.example.accessingdatamysql.dao.entities.ProductCategory;
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

public class ProductCategoryAttributeDTO {
    @NotNull
    private Integer id;

    @NotNull
    String attrName;

    @NotNull
    ProductCategoryDTO category;

    @NotNull
    List<ProductAttributeValueDTO> productAttributeValues = new ArrayList<>();
}
