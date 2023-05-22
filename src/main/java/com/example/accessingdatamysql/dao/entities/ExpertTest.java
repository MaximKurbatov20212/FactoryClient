package com.example.accessingdatamysql.dao.entities;

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
public class ExpertTest {
//    @Id

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductTest test;

//    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Expert expert;
}
