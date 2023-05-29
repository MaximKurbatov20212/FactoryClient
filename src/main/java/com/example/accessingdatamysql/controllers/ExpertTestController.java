package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.ProductTest;
import com.example.accessingdatamysql.dao.repo.ExpertTestRepository;
import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ExpertTestService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


@Component
@FxmlView("ExpertsTests.fxml")
public class ExpertTestController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;

    @FXML
    private TableView<ProductTestDTO> productTestsTable; //ok
    @FXML
    private TableView<ExpertDTO> expertsTable; // ok

    @FXML
    private TableView<ExpertTestDTO> expertTestTable;
    private final ExpertTestService expertTestService;

    public ExpertTestController(ExpertTestService service) {
        this.expertTestService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ExpertTestDTO item = expertTestTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        expertTestService.drop(item);
        expertTestTable.setItems(FXCollections.observableList(expertTestService.getAll()));
    }

    private void editEvent() {
        ExpertTestDTO expertTestItem = expertTestTable.getSelectionModel().getSelectedItem();
        if (expertTestItem == null) {
            throw new ItemException("select expertTest");
        }

        ExpertDTO expertItem = expertsTable.getSelectionModel().getSelectedItem();
        if (expertItem == null) {
            throw new ItemException("select expert");
        }

        ProductTestDTO productTestItem = productTestsTable.getSelectionModel().getSelectedItem();
        if (productTestItem == null) {
            throw new ItemException("select productTest");
        }

        expertTestService.edit(ExpertTestDTO.builder().id(expertTestItem.getId()).expert(expertItem).test(productTestItem).build());
        expertTestTable.setItems(FXCollections.observableList(expertTestService.getAll()));
    }

    private void addEvent() {
        try {
            ExpertDTO expertItem = expertsTable.getSelectionModel().getSelectedItem();
            if (expertItem == null) {
                throw new ItemException("select expert");
            }

            ProductTestDTO productTestItem = productTestsTable.getSelectionModel().getSelectedItem();
            if (productTestItem == null) {
                throw new ItemException("select productTest");
            }

            expertTestService.edit(ExpertTestDTO.builder().expert(expertItem).test(productTestItem).build());
            expertTestTable.setItems(FXCollections.observableList(expertTestService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
