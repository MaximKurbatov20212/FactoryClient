package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import com.example.accessingdatamysql.dao.entities.WorkerFunction;
import jakarta.validation.constraints.NotNull;

public class WorkerDTO {

    @NotNull
    private Integer id;
    @NotNull

    private Brigade brigade;
    @NotNull
    private WorkerFunction function;
    @NotNull
    private WorkerCategory category;
}
