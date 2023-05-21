package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import com.example.accessingdatamysql.dao.entities.PersonalFunction;
import com.example.accessingdatamysql.dao.entities.Workshop;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PersonalDTO {
    @NotNull
    private Integer id;
    @NotNull
    private PersonalFunction function;
    @NotNull
    private PersonalCategory category;
    @NotNull
    List<Workshop> workshops = new ArrayList<>();
    @NotNull
    List<PersonalAttributeValue> personalAttributeValues = new ArrayList<>();
}
