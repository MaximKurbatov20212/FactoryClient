package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ProductTestRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.LaboratoryDTO;
import com.example.accessingdatamysql.dto.ProductDTO;
import com.example.accessingdatamysql.dto.ProductTestDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ProductTestService;
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
@FxmlView("ProductsTests.fxml")
public class ProductTestController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField date;
    @FXML private TableView<ProductDTO> productsTable;
    @FXML private TableView<LaboratoryDTO> laboratoriesTable;
    @FXML private TableView<ProductTestDTO> productTestsTable;

    private final ProductTestService productTestService;

    public ProductTestController(ProductTestService service) {
        this.productTestService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductTestDTO item = productTestsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productTestService.drop(item);
        productTestsTable.setItems(FXCollections.observableList(productTestService.getAll()));
    }

    private void editEvent() {
        ProductTestDTO productTestItem = productTestsTable.getSelectionModel().getSelectedItem();
        if (productTestItem == null) {
            throw new ItemException("select productTest");
        }

        ProductDTO productItem = productsTable.getSelectionModel().getSelectedItem();
        if (productItem == null) {
            throw new ItemException("select expert");
        }

        LaboratoryDTO laboratoryItem  = laboratoriesTable.getSelectionModel().getSelectedItem();
        if (laboratoryItem == null) {
            throw new ItemException("select productTest");
        }

        productTestService.edit(ProductTestDTO.builder()
                .id(productTestItem.getId())
                .laboratory(laboratoryItem)
                .product(productItem)
                .build());
        productTestsTable.setItems(FXCollections.observableList(productTestService.getAll()));
    }

    private void addEvent() {
        try {
          ProductTestDTO productTestItem = productTestsTable.getSelectionModel().getSelectedItem();
        if (productTestItem == null) {
            throw new ItemException("select productTest");
        }

        ProductDTO productItem = productsTable.getSelectionModel().getSelectedItem();
        if (productItem == null) {
            throw new ItemException("select expert");
        }

        LaboratoryDTO laboratoryItem  = laboratoriesTable.getSelectionModel().getSelectedItem();
        if (laboratoryItem == null) {
            throw new ItemException("select productTest");
        }

        productTestService.add(ProductTestDTO.builder()
                .id(productTestItem.getId())
                .laboratory(laboratoryItem)
                .product(productItem)
                .build());
        productTestsTable.setItems(FXCollections.observableList(productTestService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
