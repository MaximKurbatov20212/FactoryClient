package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
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

public class ProductCategoryDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    List<Product> products = new ArrayList<>();
    @NotNull
    List<ProductCategoryAttribute> productCategoryAttributes = new ArrayList<>();
}
