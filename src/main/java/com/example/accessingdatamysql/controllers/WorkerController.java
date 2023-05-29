package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.WorkerRepository;
import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.BrigadeService;
import com.example.accessingdatamysql.service.WorkerFunctionService;
import com.example.accessingdatamysql.service.WorkerService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Workers.fxml")
public class WorkerController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<BrigadeDTO> brigadesTable;
    @FXML private TableView<WorkerFunctionDTO> workerFunctionsTable;
    @FXML private TableView<WorkerCategoryDTO> workerCategoriesTable;
    @FXML private TableView<WorkerDTO> workersTable;
    private final WorkerService workersService;

    public WorkerController(WorkerService service) {
        this.workersService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkerDTO item = workersTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workersService.drop(item);
        workersTable.setItems(FXCollections.observableList(workersService.getAll()));
    }

    private void editEvent() {
        WorkerDTO item = workersTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        WorkerFunctionDTO funcItem = workerFunctionsTable.getSelectionModel().getSelectedItem();
        if (funcItem == null) {
            throw new ItemException("select record");
        }

        BrigadeDTO brigadeItem = brigadesTable.getSelectionModel().getSelectedItem();
        if (brigadeItem == null) {
            throw new ItemException("select record");
        }

        WorkerCategoryDTO categoryItem = workerCategoriesTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }

        workersService.edit(WorkerDTO.builder()
                .id(item.getId())
                .brigade(brigadeItem)
                .function(funcItem)
                .category(categoryItem)
                .build()
        );

        workersTable.setItems(FXCollections.observableList(workersService.getAll()));
    }

    private void addEvent() {
        try {
            WorkerDTO item = workersTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            WorkerFunctionDTO funcItem = workerFunctionsTable.getSelectionModel().getSelectedItem();
            if (funcItem == null) {
                throw new ItemException("select record");
            }

            BrigadeDTO brigadeItem = brigadesTable.getSelectionModel().getSelectedItem();
            if (brigadeItem == null) {
                throw new ItemException("select record");
            }

            WorkerCategoryDTO categoryItem = workerCategoriesTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            workersService.add(WorkerDTO.builder()
                    .brigade(brigadeItem)
                    .function(funcItem)
                    .category(categoryItem)
                    .build()
            );

            workersTable.setItems(FXCollections.observableList(workersService.getAll()));

        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
