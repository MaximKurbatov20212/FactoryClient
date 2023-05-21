package accessingdatamysql.dao.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;


@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalAccounting {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private Date data;
    private Time time;
    @ManyToOne(fetch = FetchType.LAZY)
    private Personal person;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventWithPeople event;
}
