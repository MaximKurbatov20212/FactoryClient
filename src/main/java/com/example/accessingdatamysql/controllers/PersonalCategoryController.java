package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.PersonalCategoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalCategoryService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("PersonalCategories.fxml")
public class PersonalCategoryController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TextField name;
    @FXML
    private TableView<PersonalCategoryDTO> personalCategoriesTable;

    private final PersonalCategoryService personalCategoryService;

    public PersonalCategoryController(PersonalCategoryService service) {
        this.personalCategoryService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        PersonalCategoryDTO item = personalCategoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalCategoryService.drop(item);
        personalCategoriesTable.setItems(FXCollections.observableList(personalCategoryService.getAll()));
    }

    private void editEvent() {
        PersonalCategoryDTO item = personalCategoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalCategoryService.edit(PersonalCategoryDTO.builder().name(name.getText()).build());
        personalCategoriesTable.setItems(FXCollections.observableList(personalCategoryService.getAll()));
    }

    private void addEvent() {
        try {
            PersonalCategoryDTO item = PersonalCategoryDTO.builder().name(name.getText()).build();
            personalCategoryService.add(item);
            personalCategoriesTable.setItems(FXCollections.observableList(personalCategoryService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
