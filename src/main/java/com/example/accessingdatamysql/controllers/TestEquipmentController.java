package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.TestEquipmentRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.ProductTestDTO;
import com.example.accessingdatamysql.dto.TestEquipmentDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.TestEquipmentService;
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
@FxmlView("TestsEquipments.fxml")
public class TestEquipmentController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<EquipmentDTO> equipmentsTable;
    @FXML private TableView<ProductTestDTO> productTestTable;
    @FXML private TableView<TestEquipmentDTO> testEquipmentTable;

    private final TestEquipmentService testEquipmentService;

    public TestEquipmentController(TestEquipmentService service) {
        this.testEquipmentService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        TestEquipmentDTO item = testEquipmentTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        testEquipmentService.drop(item);
        testEquipmentTable.setItems(FXCollections.observableList(testEquipmentService.getAll()));
    }

    private void editEvent() {
        TestEquipmentDTO testEquipmentItem = testEquipmentTable.getSelectionModel().getSelectedItem();
        if (testEquipmentItem == null) {
            throw new ItemException("select testEquipment");
        }

        EquipmentDTO eqItem = equipmentsTable.getSelectionModel().getSelectedItem();
        if (eqItem == null) {
            throw new ItemException("select expert");
        }

        ProductTestDTO productTestItem = productTestTable.getSelectionModel().getSelectedItem();
        if (productTestItem == null) {
            throw new ItemException("select productTest");
        }

        testEquipmentService.edit(TestEquipmentDTO.builder()
                .id(testEquipmentItem.getId())
                .equipment(eqItem)
                .test(productTestItem)
                .build());
        testEquipmentTable.setItems(FXCollections.observableList(testEquipmentService.getAll()));
    }

    private void addEvent() {
        try {
            TestEquipmentDTO testEquipmentItem = testEquipmentTable.getSelectionModel().getSelectedItem();
            if (testEquipmentItem == null) {
                throw new ItemException("select testEquipment");
            }

            EquipmentDTO eqItem = equipmentsTable.getSelectionModel().getSelectedItem();
            if (eqItem == null) {
                throw new ItemException("select expert");
            }

            ProductTestDTO productTestItem = productTestTable.getSelectionModel().getSelectedItem();
            if (productTestItem == null) {
                throw new ItemException("select productTest");
            }

            testEquipmentService.add(TestEquipmentDTO.builder()
                    .id(testEquipmentItem.getId())
                    .equipment(eqItem)
                    .test(productTestItem)
                    .build());
            testEquipmentTable.setItems(FXCollections.observableList(testEquipmentService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }

}
