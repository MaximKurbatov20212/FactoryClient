package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ProductAccounting;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EventWithProductDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;

    @NotNull
    List<ProductAccounting> productAccountingList = new ArrayList<>();
}
