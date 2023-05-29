package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.Factory;
import com.example.accessingdatamysql.dao.entities.Workshop;
import com.example.accessingdatamysql.dao.repo.WorkshopRepository;
import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.WorkshopService;
import com.zaxxer.hikari.util.ClockSource;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;

@Component
@FxmlView("Workshops.fxml")
public class WorkshopController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<WorkshopDTO> workshopsTable;
    @FXML private TableView<FactoryDTO> factoriesTable;
    @FXML private TableView<PersonalDTO> personalTable;

    private final WorkshopService workshopsService;

    public WorkshopController(WorkshopService service) {
        this.workshopsService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkshopDTO item = workshopsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workshopsService.drop(item);
        workshopsTable.setItems(FXCollections.observableList(workshopsService.getAll()));
    }

    private void editEvent() {
        WorkshopDTO item = workshopsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();
        if (personalItem == null) {
            throw new ItemException("select record");
        }

        FactoryDTO factoryItem = factoriesTable.getSelectionModel().getSelectedItem();
        if (factoryItem == null) {
            throw new ItemException("select record");
        }

        workshopsService.edit(WorkshopDTO.builder()
                .id(item.getId())
                .director(personalItem)
                .factory(factoryItem)
                .build()
        );

        workshopsTable.setItems(FXCollections.observableList(workshopsService.getAll()));
    }

    private void addEvent() {
        try {
            WorkshopDTO item = workshopsTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();
            if (personalItem == null) {
                throw new ItemException("select record");
            }

            FactoryDTO factoryItem = factoriesTable.getSelectionModel().getSelectedItem();
            if (factoryItem == null) {
                throw new ItemException("select record");
            }

            workshopsService.edit(WorkshopDTO.builder()
                    .director(personalItem)
                    .factory(factoryItem)
                    .build()
            );

            workshopsTable.setItems(FXCollections.observableList(workshopsService.getAll()));
            } catch (Exception e) {
                System.err.println("factory add error");
        }
    }
}