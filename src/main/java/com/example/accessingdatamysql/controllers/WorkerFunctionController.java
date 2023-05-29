package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.WorkerFunctionDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.WorkerFunctionService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


@Component
@FxmlView("WorkerFunctions.fxml")
public class WorkerFunctionController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<WorkerFunctionDTO> workerFunctionsTable;
    private final WorkerFunctionService workerFunctionsService;

    public WorkerFunctionController(WorkerFunctionService service) {
        this.workerFunctionsService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkerFunctionDTO item =  workerFunctionsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workerFunctionsService.drop(item);
        workerFunctionsTable.setItems(FXCollections.observableList(workerFunctionsService.getAll()));
    }

    private void editEvent() {
        WorkerFunctionDTO item =  workerFunctionsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workerFunctionsService.edit(WorkerFunctionDTO.builder().name(name.getText()).build());
        workerFunctionsTable.setItems(FXCollections.observableList(workerFunctionsService.getAll()));
    }

    private void addEvent() {
        try {
            WorkerFunctionDTO item = WorkerFunctionDTO.builder().name(name.getText()).build();
            workerFunctionsService.add(item);
            workerFunctionsTable.setItems(FXCollections.observableList(workerFunctionsService.getAll()));
        }
        catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
