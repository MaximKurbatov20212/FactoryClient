package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.LaboratoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.LaboratoryService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Laboratories.fxml")
public class LaboratoryController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TextField name;
    @FXML
    private TableView<LaboratoryDTO> laboratoriesTable;

    private final LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService service) {
        this.laboratoryService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        LaboratoryDTO item = laboratoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        laboratoryService.drop(item);
        laboratoriesTable.setItems(FXCollections.observableList(laboratoryService.getAll()));
    }

    private void editEvent() {
        LaboratoryDTO item = laboratoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        laboratoryService.edit(LaboratoryDTO.builder().name(name.getText()).build());
        laboratoriesTable.setItems(FXCollections.observableList(laboratoryService.getAll()));
    }

    private void addEvent() {
        try {
            LaboratoryDTO item = LaboratoryDTO.builder().name(name.getText()).build();
            laboratoryService.add(item);
            laboratoriesTable.setItems(FXCollections.observableList(laboratoryService.getAll()));
        } catch (Exception e) {
            System.err.println("laboratory add error");
        }
    }
}
