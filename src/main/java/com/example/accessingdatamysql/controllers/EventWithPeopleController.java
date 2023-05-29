package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.EventWithPeopleService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("EventWithPeople.fxml")
public class EventWithPeopleController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<EventWithPeopleDTO> eventWithPeopleTable;
    private final EventWithPeopleService eventWithPeopleService;

    public EventWithPeopleController(EventWithPeopleService service) {
        this.eventWithPeopleService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        EventWithPeopleDTO item =  eventWithPeopleTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        eventWithPeopleService.drop(item);
        eventWithPeopleTable.setItems(FXCollections.observableList(eventWithPeopleService.getAll()));
    }

    private void editEvent() {
        EventWithPeopleDTO item =  eventWithPeopleTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        eventWithPeopleService.edit(EventWithPeopleDTO.builder().name(name.getText()).build());
        eventWithPeopleTable.setItems(FXCollections.observableList(eventWithPeopleService.getAll()));
    }

    private void addEvent() {
        try {
            EventWithPeopleDTO item = EventWithPeopleDTO.builder().name(name.getText()).build();
            eventWithPeopleService.add(item);
            eventWithPeopleTable.setItems(FXCollections.observableList(eventWithPeopleService.getAll()));
        }
        catch (Exception e) {
            System.err.println("eventWithPeople add error");
        }
    }
}
