package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Worker;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WorkerFunctionDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    List<Worker> workers= new ArrayList<>();
}
