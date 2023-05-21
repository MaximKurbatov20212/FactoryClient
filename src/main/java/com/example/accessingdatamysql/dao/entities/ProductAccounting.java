package com.example.accessingdatamysql.dao.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;


@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductAccounting {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private Date data;
    private Time time;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventWithProduct event;
}
