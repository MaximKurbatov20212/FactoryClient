package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.EventWithPeople;
import com.example.accessingdatamysql.dao.entities.Personal;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PersonalAccountingDTO {
    @NotNull
    private Integer id;
    @NotNull
    private Date data;
    @NotNull
    private PersonalDTO person;
    @NotNull
    private EventWithPeopleDTO event;
}
