package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.WorkerAccounting;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EventWithPeopleDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    List<WorkerAccounting> workerAccountingList = new ArrayList<>();
}
