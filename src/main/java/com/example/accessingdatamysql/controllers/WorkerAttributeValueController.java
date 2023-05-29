package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.WorkerAttributeValueRepository;
import com.example.accessingdatamysql.dto.WorkerAttributeValueDTO;
import com.example.accessingdatamysql.dto.WorkerCategoryDTO;
import com.example.accessingdatamysql.dto.WorkerDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalAttributeValueService;
import com.example.accessingdatamysql.service.WorkerAttributeValueService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FxmlView("WorkerAttributeValue.fxml")
public class WorkerAttributeValueController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;

    @FXML private TextField value;
    @FXML private TableView<WorkerDTO> workersTable;
    @FXML private TableView<WorkerCategoryDTO> workerCategoriesTable;
    @FXML private TableView<WorkerAttributeValueDTO> workerAttributeValueTable;

    private final WorkerAttributeValueService workerAttributeValueService;

    public WorkerAttributeValueController(WorkerAttributeValueService service) {
        this.workerAttributeValueService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkerAttributeValueDTO item = workerAttributeValueTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workerAttributeValueService.drop(item);
        workerAttributeValueTable.setItems(FXCollections.observableList(workerAttributeValueService.getAll()));
    }

    private void editEvent() {
        WorkerAttributeValueDTO workerAttributeValueItem = workerAttributeValueTable.getSelectionModel().getSelectedItem();
        if (workerAttributeValueItem == null) {
            throw new ItemException("select record");
        }

        WorkerCategoryDTO categoryItem = workerCategoriesTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }

        WorkerDTO workerItem = workersTable.getSelectionModel().getSelectedItem();
        if (workerItem == null) {
            throw new ItemException("select record");
        }

        workerAttributeValueService.edit(WorkerAttributeValueDTO.builder()
                .id(workerAttributeValueItem.getId())
                .person(workerItem)
                .value(value.getText())
                .build());
        workerAttributeValueTable.setItems(FXCollections.observableList(workerAttributeValueService.getAll()));
    }

    private void addEvent() {
        try {
            WorkerAttributeValueDTO workerAttributeValueItem = workerAttributeValueTable.getSelectionModel().getSelectedItem();
            if (workerAttributeValueItem == null) {
                throw new ItemException("select record");
            }

            WorkerCategoryDTO categoryItem = workerCategoriesTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            WorkerDTO workerItem = workersTable.getSelectionModel().getSelectedItem();
            if (workerItem == null) {
                throw new ItemException("select record");
            }

            workerAttributeValueService.edit(WorkerAttributeValueDTO.builder()
                    .person(workerItem)
                    .value(value.getText())
                    .build());
            workerAttributeValueTable.setItems(FXCollections.observableList(workerAttributeValueService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
