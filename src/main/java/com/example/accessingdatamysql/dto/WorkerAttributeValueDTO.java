package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Worker;
import com.example.accessingdatamysql.dao.entities.WorkerCategoryAttribute;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerAttributeValueDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String value;
    @NotNull
    private WorkerDTO person;
    @NotNull
    private WorkerCategoryAttributeDTO attribute;
}
