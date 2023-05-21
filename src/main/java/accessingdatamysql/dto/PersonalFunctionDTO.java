package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Personal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PersonalFunctionDTO {
    @NotNull
    private Integer id;
    @NotNull
    String name;
    @NotNull
    List<Personal> personalList = new ArrayList<>();
}
