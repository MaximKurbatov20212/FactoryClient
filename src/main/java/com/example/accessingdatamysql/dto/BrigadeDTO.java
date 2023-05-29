package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Site;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BrigadeDTO {
    @NotNull
    private Integer id;
    @NotNull
    private SiteDTO site;
}
