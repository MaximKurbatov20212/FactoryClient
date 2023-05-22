package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Workshop;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FactoryDTO {

    @NotNull
    private Integer id;

    @NotNull
    List<Workshop> workshops = new ArrayList<>();
}
