package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.WorkerAttributeValue;
import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerCategoryAttributeDTO {

    @NotNull
    private Integer id;
    @NotNull
    String attrName;

    @NotNull
    WorkerCategoryDTO category;

    @NotNull
    List<WorkerAttributeValueDTO> workerAttributeValues = new ArrayList<>();
}
