package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PersonalCategoryDTO {

    @NotNull
    private Integer id;
    @NotNull
    String name;
    @NotNull
    List<Personal> personalList = new ArrayList<>();

    @NotNull
    List<PersonalCategoryAttribute> personalCategoryAttributes = new ArrayList<>();
}
