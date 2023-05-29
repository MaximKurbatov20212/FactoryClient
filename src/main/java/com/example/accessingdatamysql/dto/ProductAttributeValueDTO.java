package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductAttributeValueDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String value;
    @NotNull
    private ProductDTO product;
    @NotNull
    private ProductCategoryAttributeDTO attribute;
}
