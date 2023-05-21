package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.EventWithPeople;
import com.example.accessingdatamysql.dao.entities.Worker;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Time;

public class WorkerAccountingDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Date data;
    @NotNull
    private Time time;
    @NotNull

    private Worker person;
    @NotNull
    private EventWithPeople event;
}
