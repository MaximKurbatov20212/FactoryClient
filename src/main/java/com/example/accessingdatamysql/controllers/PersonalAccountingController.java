package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalAccountingService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.ZoneId;

@Component
@FxmlView("PersonalAccounting.fxml")
public class PersonalAccountingController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private DatePicker date;
    @FXML
    private TableView<PersonalAccountingDTO> personalAccountingTable;
    @FXML
    private TableView<PersonalDTO> personalTable;
    @FXML
    private TableView<EventWithPeopleDTO> eventWithPeopleTable;
    private final PersonalAccountingService personalAccountingService;

    public PersonalAccountingController(PersonalAccountingService service) {
        this.personalAccountingService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        PersonalAccountingDTO item = personalAccountingTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalAccountingService.drop(item);
        personalAccountingTable.setItems(FXCollections.observableList(personalAccountingService.getAll()));
    }

    private void editEvent() {
        PersonalAccountingDTO item = personalAccountingTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();
        if (personalItem == null) {
            throw new ItemException("select record");
        }

        EventWithPeopleDTO eventItem = eventWithPeopleTable.getSelectionModel().getSelectedItem();
        if (eventItem == null) {
            throw new ItemException("select record");
        }

        personalAccountingService.edit(PersonalAccountingDTO.builder()
                .id(personalItem.getId())
                .person(personalItem)
                .event(eventItem)
                .data(Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                .build()
        );

        personalAccountingTable.setItems(FXCollections.observableList(personalAccountingService.getAll()));
    }

    private void addEvent() {
        try {
            PersonalAccountingDTO item = personalAccountingTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();
            if (personalItem == null) {
                throw new ItemException("select record");
            }

            EventWithPeopleDTO eventItem = eventWithPeopleTable.getSelectionModel().getSelectedItem();
            if (eventItem == null) {
                throw new ItemException("select record");
            }

            personalAccountingService.edit(PersonalAccountingDTO.builder()
                    .person(personalItem)
                    .event(eventItem)
                    .data(Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                    .build()
            );

            personalAccountingTable.setItems(FXCollections.observableList(personalAccountingService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
