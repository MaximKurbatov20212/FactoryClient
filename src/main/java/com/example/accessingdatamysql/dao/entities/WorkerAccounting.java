package com.example.accessingdatamysql.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;


@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerAccounting {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private Date data;
    private Time time;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker person;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventWithPeople event;
}
