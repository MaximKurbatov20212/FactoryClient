package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import com.example.accessingdatamysql.dao.entities.WorkerFunction;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {

    @NotNull
    private Integer id;
    @NotNull

    private BrigadeDTO brigade;
    private WorkerFunctionDTO function;
    @NotNull
    private WorkerCategoryDTO category;
}
