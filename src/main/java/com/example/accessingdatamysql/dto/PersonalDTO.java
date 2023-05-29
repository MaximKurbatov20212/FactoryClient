package com.example.accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import com.example.accessingdatamysql.dao.entities.PersonalFunction;
import com.example.accessingdatamysql.dao.entities.Workshop;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDTO {
    @NotNull
    private Integer id;
    private PersonalFunctionDTO function;
    @NotNull
    private PersonalCategoryDTO category;
    @NotNull
    List<Workshop> workshops = new ArrayList<>();
    @NotNull
    List<PersonalAttributeValue> personalAttributeValues = new ArrayList<>();
}
