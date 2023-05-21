package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Site;
import jakarta.validation.constraints.NotNull;

public class BrigadeDTO {
    @NotNull
    private Integer id;
    @NotNull
    private Site site;
}
