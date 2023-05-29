package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.ProductTypeDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ProductTypeService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("ProductsTypes.fxml")
public class ProductTypeController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TextField name;
    @FXML
    private TableView<ProductTypeDTO> productTypesTable;

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService service) {
        this.productTypeService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductTypeDTO item = productTypesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productTypeService.drop(item);
        productTypesTable.setItems(FXCollections.observableList(productTypeService.getAll()));
    }

    private void editEvent() {
        ProductTypeDTO item = productTypesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productTypeService.edit(ProductTypeDTO.builder().name(name.getText()).build());
        productTypesTable.setItems(FXCollections.observableList(productTypeService.getAll()));
    }

    private void addEvent() {
        try {
            ProductTypeDTO item = ProductTypeDTO.builder().name(name.getText()).build();
            productTypeService.add(item);
            productTypesTable.setItems(FXCollections.observableList(productTypeService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
