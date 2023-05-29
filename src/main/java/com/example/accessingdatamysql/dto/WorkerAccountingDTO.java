package com.example.accessingdatamysql.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerAccountingDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Date data;
    @NotNull
    private WorkerDTO person;
    @NotNull
    private EventWithPeopleDTO event;
}
