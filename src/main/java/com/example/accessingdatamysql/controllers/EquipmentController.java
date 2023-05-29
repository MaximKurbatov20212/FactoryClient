package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.EquipmentService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Equipments.fxml")
public class EquipmentController {
    @FXML private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<EquipmentDTO> equipmentsTable;

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService service) {
        this.equipmentService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        EquipmentDTO item =  equipmentsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        equipmentService.drop(item);
        equipmentsTable.setItems(FXCollections.observableList(equipmentService.getAll()));
    }

    private void editEvent() {
        EquipmentDTO item =  equipmentsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        equipmentService.edit(EquipmentDTO.builder().name(name.getText()).build());
        equipmentsTable.setItems(FXCollections.observableList(equipmentService.getAll()));
    }

    private void addEvent() {
        try {
            EquipmentDTO item = EquipmentDTO.builder().name(name.getText()).build();
            equipmentService.add(item);
            equipmentsTable.setItems(FXCollections.observableList(equipmentService.getAll()));
        }
        catch (Exception e) {
            System.err.println("equipment add error");
        }
    }
}
