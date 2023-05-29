package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalCategoryAttributeService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("PersonalCategoryAttributes.fxml")

public class PersonalCategoryAttributeController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField attrName;
    @FXML private TableView<PersonalCategoryDTO> personalCategoryTable;
    @FXML private TableView<PersonalCategoryAttributeDTO> personalCategoryAttributeTable;

    private final PersonalCategoryAttributeService personalCategoryAttributeService;

    public PersonalCategoryAttributeController(PersonalCategoryAttributeService service) {
        this.personalCategoryAttributeService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        PersonalCategoryAttributeDTO item = personalCategoryAttributeTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalCategoryAttributeService.drop(item);
        personalCategoryAttributeTable.setItems(FXCollections.observableList(personalCategoryAttributeService.getAll()));
    }

    private void editEvent() {
        PersonalCategoryAttributeDTO item = personalCategoryAttributeTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        PersonalCategoryDTO categoryItem = personalCategoryTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }


        personalCategoryAttributeService.edit(PersonalCategoryAttributeDTO.builder()
                .id(item.getId())
                .category(categoryItem)
                .attrName(attrName.getText())
                .build()
        );

        personalCategoryAttributeTable.setItems(FXCollections.observableList(personalCategoryAttributeService.getAll()));
    }

    private void addEvent() {
        try {
            PersonalCategoryAttributeDTO item = personalCategoryAttributeTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        PersonalCategoryDTO categoryItem = personalCategoryTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }


        personalCategoryAttributeService.edit(PersonalCategoryAttributeDTO.builder()
                .category(categoryItem)
                .attrName(attrName.getText())
                .build()
        );

        personalCategoryAttributeTable.setItems(FXCollections.observableList(personalCategoryAttributeService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}