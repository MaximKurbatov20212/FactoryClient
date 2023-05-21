package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.Workshop;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SiteDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Personal director;
    @NotNull
    private Workshop workshop;
    @NotNull

    List<Brigade> brigades = new ArrayList<>();

}
