package com.example.accessingdatamysql.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerCategoryAttribute {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    WorkerCategory category;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    List<WorkerAttributeValue> workerAttributeValues = new ArrayList<>();
}
