package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
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
