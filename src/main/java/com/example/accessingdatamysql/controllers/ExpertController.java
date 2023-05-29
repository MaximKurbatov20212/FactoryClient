package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ExpertRepository;
import com.example.accessingdatamysql.dto.ExpertDTO;
import com.example.accessingdatamysql.dto.ExpertDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ExpertService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Experts.fxml")
public class ExpertController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TextField name;
    @FXML
    private TableView<ExpertDTO> expertsTable;
    private final ExpertService expertService;

    public ExpertController(ExpertService service) {
        this.expertService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ExpertDTO item = expertsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        expertService.drop(item);
        expertsTable.setItems(FXCollections.observableList(expertService.getAll()));
    }

    private void editEvent() {
        ExpertDTO item = expertsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        expertService.edit(ExpertDTO.builder().name(name.getText()).build());
        expertsTable.setItems(FXCollections.observableList(expertService.getAll()));
    }

    private void addEvent() {
        try {
            ExpertDTO item = ExpertDTO.builder().name(name.getText()).build();
            expertService.add(item);
            expertsTable.setItems(FXCollections.observableList(expertService.getAll()));
        } catch (Exception e) {
            System.err.println("expert add error");
        }
    }
}
