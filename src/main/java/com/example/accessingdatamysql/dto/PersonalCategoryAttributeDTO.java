package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PersonalCategoryAttributeDTO {
    @NotNull
    private Integer id;

    @NotNull
    PersonalCategory category;

    @NotNull
    List<PersonalAttributeValue> personalAttributeValues = new ArrayList<>();
}
