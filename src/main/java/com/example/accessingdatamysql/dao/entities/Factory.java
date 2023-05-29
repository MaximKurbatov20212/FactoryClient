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
@Table(name="Factories")
public class Factory {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "factory", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Workshop> workshops = new ArrayList<>();

    public Factory(String text) {
        this.name = text;
    }

    public Factory(int i, String text) {
        id = i;
        name = text;
    }

    public void addWorkshop(Workshop workshop) {
        workshops.add(workshop);
        workshop.setFactory(this);
    }
    public void removeWorkshop(Workshop workshop) {
        workshops.remove(workshop);
        workshop.setFactory(null);
    }
}
