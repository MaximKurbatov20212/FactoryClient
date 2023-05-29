package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.entities.Site;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionCycleDTO {
    @NotNull
    private Integer id;
    @NotNull
    private ProductDTO product;
    @NotNull
    private SiteDTO site;
    @NotNull
    private BrigadeDTO brigade;
}
