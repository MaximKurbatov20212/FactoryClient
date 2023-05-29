package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.WorkerCategoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.WorkerCategoryService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


@Component
@FxmlView("WorkerCategories.fxml")
public class WorkerCategoryController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<WorkerCategoryDTO> workerCategoriesTable;

    private final WorkerCategoryService workerCategoryService;

    public WorkerCategoryController(WorkerCategoryService service) {
        this.workerCategoryService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkerCategoryDTO item =  workerCategoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workerCategoryService.drop(item);
        workerCategoriesTable.setItems(FXCollections.observableList(workerCategoryService.getAll()));
    }

    private void editEvent() {
        WorkerCategoryDTO item =  workerCategoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workerCategoryService.edit(WorkerCategoryDTO.builder().name(name.getText()).build());
        workerCategoriesTable.setItems(FXCollections.observableList(workerCategoryService.getAll()));
    }

    private void addEvent() {
        try {
            WorkerCategoryDTO item = WorkerCategoryDTO.builder().name(name.getText()).build();
            workerCategoryService.add(item);
            workerCategoriesTable.setItems(FXCollections.observableList(workerCategoryService.getAll()));
        }
        catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
