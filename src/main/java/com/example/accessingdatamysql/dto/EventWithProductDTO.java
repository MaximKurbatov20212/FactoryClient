package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.ProductAccounting;
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

public class EventWithProductDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;

    @NotNull
    List<ProductAccounting> productAccountingList = new ArrayList<>();
}
