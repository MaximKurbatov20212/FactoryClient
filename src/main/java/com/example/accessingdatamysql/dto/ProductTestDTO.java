package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ExpertTest;
import com.example.accessingdatamysql.dao.entities.Laboratory;
import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.TestEquipment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductTestDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Laboratory laboratory;
    @NotNull
    private Product product;
    @NotNull
    List<TestEquipment> testEquipments = new ArrayList<>();
    @NotNull
    List<ExpertTest> expertTests = new ArrayList<>();
}
