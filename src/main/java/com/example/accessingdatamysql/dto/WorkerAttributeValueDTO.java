package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Worker;
import com.example.accessingdatamysql.dao.entities.WorkerCategoryAttribute;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class WorkerAttributeValueDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String value;
    @NotNull
    private Worker person;
    @NotNull
    private WorkerCategoryAttribute attribute;
}
