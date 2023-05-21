package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ExpertDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    List<ExpertTest> expertTests = new ArrayList<>();
}
