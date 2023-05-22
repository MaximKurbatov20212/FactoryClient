package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import jakarta.validation.constraints.NotNull;

public class PersonalAttributeValueDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String value;

    @NotNull
    private Personal person;
    @NotNull
    private PersonalCategoryAttribute attribute;
}
