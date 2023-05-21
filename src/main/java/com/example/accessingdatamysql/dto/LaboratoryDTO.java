package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ProductTest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;

    @NotNull
    List<ProductTest> productTests = new ArrayList<>();
}
