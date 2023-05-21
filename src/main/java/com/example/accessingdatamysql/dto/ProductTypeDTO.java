package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;

    @NotNull
    List<Product> products = new ArrayList<>();
}
