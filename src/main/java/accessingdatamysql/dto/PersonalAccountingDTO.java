package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.EventWithPeople;
import com.example.accessingdatamysql.dao.entities.Personal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Time;

public class PersonalAccountingDTO {
    @NotNull
    private Integer id;
    @NotNull
    private Date data;
    @NotNull
    private Time time;
    @NotNull
    private Personal person;
    @NotNull
    private EventWithPeople event;
}
