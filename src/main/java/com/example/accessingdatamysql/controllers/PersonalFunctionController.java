package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalFunctionService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("PersonalFunctions.fxml")
public class PersonalFunctionController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TextField name;
    @FXML
    private TableView<PersonalFunctionDTO> personalFunctionsTable;
    private final PersonalFunctionService personalFunctionService;

    public PersonalFunctionController(PersonalFunctionService service) {
        this.personalFunctionService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        PersonalFunctionDTO item = personalFunctionsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalFunctionService.drop(item);
        personalFunctionsTable.setItems(FXCollections.observableList(personalFunctionService.getAll()));
    }

    private void editEvent() {
        PersonalFunctionDTO item = personalFunctionsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalFunctionService.edit(PersonalFunctionDTO.builder().name(name.getText()).build());
        personalFunctionsTable.setItems(FXCollections.observableList(personalFunctionService.getAll()));
    }

    private void addEvent() {
        try {
            PersonalFunctionDTO item = PersonalFunctionDTO.builder().name(name.getText()).build();
            personalFunctionService.add(item);
            personalFunctionsTable.setItems(FXCollections.observableList(personalFunctionService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}