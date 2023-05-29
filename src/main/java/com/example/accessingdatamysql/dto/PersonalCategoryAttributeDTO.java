package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalCategory;
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

public class PersonalCategoryAttributeDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String attrName;
    @NotNull
    PersonalCategoryDTO category;

    @NotNull
    List<PersonalAttributeValueDTO> personalAttributeValues = new ArrayList<>();
}
