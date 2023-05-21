package accessingdatamysql.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerAttributeValue {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker person;
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkerCategoryAttribute attribute;
}
