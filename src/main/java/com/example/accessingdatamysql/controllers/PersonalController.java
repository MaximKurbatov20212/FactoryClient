package com.example.accessingdatamysql.controllers;
import com.example.accessingdatamysql.dto.PersonalCategoryDTO;
import com.example.accessingdatamysql.dto.PersonalDTO;
import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalCategoryAttributeService;
import com.example.accessingdatamysql.service.PersonalService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Personal.fxml")

public class PersonalController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<PersonalCategoryDTO> personalCategoriesTable;
    @FXML private TableView<PersonalFunctionDTO> personalFunctionsTable;
    @FXML private TableView<PersonalDTO> personalTable;
    private final PersonalService personalService;

    public PersonalController(PersonalService service) {
        this.personalService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        PersonalDTO item = personalTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        personalService.drop(item);
        personalTable.setItems(FXCollections.observableList(personalService.getAll()));
    }

    private void editEvent() {
        PersonalDTO item = personalTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        PersonalCategoryDTO categoryItem = personalCategoriesTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }

        PersonalFunctionDTO funcItem = personalFunctionsTable.getSelectionModel().getSelectedItem();
        if (funcItem == null) {
            throw new ItemException("select record");
        }

        personalService.edit(PersonalDTO.builder()
                .id(item.getId())
                .category(categoryItem)
                .function(funcItem)
                .build()
        );

        personalTable.setItems(FXCollections.observableList(personalService.getAll()));
    }

    private void addEvent() {
        try {
            PersonalDTO item = personalTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            PersonalCategoryDTO categoryItem = personalCategoriesTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            PersonalFunctionDTO funcItem = personalFunctionsTable.getSelectionModel().getSelectedItem();
            if (funcItem == null) {
                throw new ItemException("select record");
            }

            personalService.add(PersonalDTO.builder()
                    .id(item.getId())
                    .category(categoryItem)
                    .function(funcItem)
                    .build()
            );

            personalTable.setItems(FXCollections.observableList(personalService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }

}
