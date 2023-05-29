package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.EventWithProductDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.EventWithProductService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("EventWithProducts.fxml")
public class EventWithProductController {
    @FXML private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<EventWithProductDTO> eventWithProductTable;

    private final EventWithProductService eventWithProductService;

    public EventWithProductController(EventWithProductService service) {
        this.eventWithProductService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        EventWithProductDTO item =  eventWithProductTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        eventWithProductService.drop(item);
        eventWithProductTable.setItems(FXCollections.observableList(eventWithProductService.getAll()));
    }

    private void editEvent() {
        EventWithProductDTO item =  eventWithProductTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        eventWithProductService.edit(EventWithProductDTO.builder().name(name.getText()).build());
        eventWithProductTable.setItems(FXCollections.observableList(eventWithProductService.getAll()));
    }

    private void addEvent() {
        try {
            EventWithProductDTO item = EventWithProductDTO.builder().name(name.getText()).build();
            eventWithProductService.add(item);
            eventWithProductTable.setItems(FXCollections.observableList(eventWithProductService.getAll()));
        } catch (Exception e) {
            System.err.println("eventWithProduct add error");
        }
    }
}
