package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Factory;
import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.Site;
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
public class WorkshopDTO {
    @NotNull
    private Integer id;
    @NotNull
    private FactoryDTO factory;
    @NotNull
    private PersonalDTO director;
    @NotNull
    List<Site> sites = new ArrayList<>();
}
