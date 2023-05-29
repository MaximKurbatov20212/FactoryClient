package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.PersonalCategoryDTO;
import com.example.accessingdatamysql.dto.WorkerCategoryAttributeDTO;
import com.example.accessingdatamysql.dto.WorkerCategoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.WorkerCategoryAttributeService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("WorkerCategoryAttributes.fxml")
public class WorkerCategoryAttributeController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;

    @FXML private TextField attrName;
    @FXML private TableView<WorkerCategoryDTO> workerCategoriesTable;
    @FXML private TableView<WorkerCategoryAttributeDTO> workerCategoryAttributesTable;
    private final WorkerCategoryAttributeService personalCategoryAttributeService;

    public WorkerCategoryAttributeController(WorkerCategoryAttributeService service) {
        this.personalCategoryAttributeService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkerCategoryAttributeDTO item = workerCategoryAttributesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalCategoryAttributeService.drop(item);
        workerCategoryAttributesTable.setItems(FXCollections.observableList(personalCategoryAttributeService.getAll()));
    }

    private void editEvent() {
        WorkerCategoryAttributeDTO item = workerCategoryAttributesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        WorkerCategoryDTO categoryItem = workerCategoriesTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }


        personalCategoryAttributeService.edit(WorkerCategoryAttributeDTO.builder()
            .id(item.getId())
            .category(categoryItem)
            .attrName(attrName.getText())
            .build()
        );

        workerCategoryAttributesTable.setItems(FXCollections.observableList(personalCategoryAttributeService.getAll()));
    }

    private void addEvent() {
        try {
            WorkerCategoryAttributeDTO item = workerCategoryAttributesTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            WorkerCategoryDTO categoryItem = workerCategoriesTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }


            personalCategoryAttributeService.edit(WorkerCategoryAttributeDTO.builder()
                    .category(categoryItem)
                    .attrName(attrName.getText())
                    .build()
            );

            workerCategoryAttributesTable.setItems(FXCollections.observableList(personalCategoryAttributeService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }

}
