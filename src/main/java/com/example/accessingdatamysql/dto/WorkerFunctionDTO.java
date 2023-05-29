package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Worker;
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
public class WorkerFunctionDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    List<Worker> workers= new ArrayList<>();
}
