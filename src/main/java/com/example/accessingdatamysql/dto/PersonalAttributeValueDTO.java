package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PersonalAttributeValueDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String value;

    @NotNull
    private PersonalDTO person;
    @NotNull
    private PersonalCategoryAttributeDTO attribute;
}
