package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Brigade;
import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.Workshop;
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
public class SiteDTO {

    @NotNull
    private Integer id;
    @NotNull
    private PersonalDTO director;
    @NotNull
    private WorkshopDTO workshop;
    @NotNull

    List<BrigadeDTO> brigades = new ArrayList<>();

}
