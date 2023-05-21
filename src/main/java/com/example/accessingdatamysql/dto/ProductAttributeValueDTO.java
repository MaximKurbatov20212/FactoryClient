package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class ProductAttributeValueDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String value;
    @NotNull
    private Product product;
    @NotNull
    private ProductCategoryAttribute attribute;
}
