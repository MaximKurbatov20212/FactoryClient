package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalAttributeValueService;
import com.example.accessingdatamysql.service.PersonalCategoryService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("PersonalAttributeValue.fxml")
public class PersonalAttributeValueController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TextField value;
    @FXML
    private TableView<PersonalDTO> personalTable;
    @FXML
    private TableView<PersonalCategoryDTO> personalCategoryTable;
    @FXML
    private TableView<PersonalAttributeValueDTO> personalAttributeValueTable;

    private final PersonalAttributeValueService personalAttributeValueService;

    public PersonalAttributeValueController(PersonalAttributeValueService service) {
        this.personalAttributeValueService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        PersonalAttributeValueDTO item = personalAttributeValueTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalAttributeValueService.drop(item);
        personalAttributeValueTable.setItems(FXCollections.observableList(personalAttributeValueService.getAll()));
    }

    private void editEvent() {
        PersonalAttributeValueDTO personalAttributeValueItem = personalAttributeValueTable.getSelectionModel().getSelectedItem();
        if (personalAttributeValueItem == null) {
            throw new ItemException("select record");
        }

        PersonalCategoryDTO categoryItem = personalCategoryTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }

        PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();
        if (personalItem == null) {
            throw new ItemException("select record");
        }

        personalAttributeValueService.edit(PersonalAttributeValueDTO.builder()
                .id(personalAttributeValueItem.getId())
                .person(personalItem)
                .value(value.getText())
                .build());
        personalAttributeValueTable.setItems(FXCollections.observableList(personalAttributeValueService.getAll()));
    }

    private void addEvent() {
        try {
            PersonalAttributeValueDTO personalAttributeValueItem = personalAttributeValueTable.getSelectionModel().getSelectedItem();
            if (personalAttributeValueItem == null) {
                throw new ItemException("select record");
            }

            PersonalCategoryDTO categoryItem = personalCategoryTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();
            if (personalItem == null) {
                throw new ItemException("select record");
            }

            personalAttributeValueService.edit(PersonalAttributeValueDTO.builder()
                    .person(personalItem)
                    .value(value.getText())
                    .build());
            personalAttributeValueTable.setItems(FXCollections.observableList(personalAttributeValueService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}