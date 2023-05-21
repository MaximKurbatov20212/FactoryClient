package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Expert;
import com.example.accessingdatamysql.dao.entities.ProductTest;
import jakarta.validation.constraints.NotNull;

public class ExpertTestDTO {

    @NotNull
    private Integer id;

    @NotNull
    private ProductTest test;

    @NotNull
    private Expert expert;
}
