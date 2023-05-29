package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.ProductAttributeValue;
import com.example.accessingdatamysql.dao.entities.ProductCategoryAttribute;
import com.example.accessingdatamysql.dao.repo.ProductAttributeValueRepository;
import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ProductAttributeValueService;
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
@FxmlView("ProductAttributeValue.fxml")
public class ProductAttributeValueController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField value;
    @FXML private TableView<ProductDTO> productTable;
    @FXML private TableView<ProductCategoryAttributeDTO> productCategoryAttributesTable;
    @FXML private TableView<ProductAttributeValueDTO> productAttributeValueTable;

    private final ProductAttributeValueService productAttributeValueService;

    public ProductAttributeValueController(ProductAttributeValueService service) {
        this.productAttributeValueService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductAttributeValueDTO item = productAttributeValueTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productAttributeValueService.drop(item);
        productAttributeValueTable.setItems(FXCollections.observableList(productAttributeValueService.getAll()));
    }

    private void editEvent() {
        ProductAttributeValueDTO productAttributeValueItem = productAttributeValueTable.getSelectionModel().getSelectedItem();
        if (productAttributeValueItem == null) {
            throw new ItemException("select record");
        }

        ProductCategoryAttributeDTO categoryItem = productCategoryAttributesTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }

        ProductDTO productItem = productTable.getSelectionModel().getSelectedItem();
        if (productItem == null) {
            throw new ItemException("select record");
        }

        productAttributeValueService.edit(ProductAttributeValueDTO.builder()
                .id(productAttributeValueItem.getId())
                .product(productItem)
                .value(value.getText())
                .build());
        productAttributeValueTable.setItems(FXCollections.observableList(productAttributeValueService.getAll()));
    }

    private void addEvent() {
        try {
            ProductAttributeValueDTO productAttributeValueItem = productAttributeValueTable.getSelectionModel().getSelectedItem();
            if (productAttributeValueItem == null) {
                throw new ItemException("select record");
            }

            ProductCategoryAttributeDTO categoryItem = productCategoryAttributesTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            ProductDTO productItem = productTable.getSelectionModel().getSelectedItem();
            if (productItem == null) {
                throw new ItemException("select record");
            }

            productAttributeValueService.edit(ProductAttributeValueDTO.builder()
                    .product(productItem)
                    .value(value.getText())
                    .build());
            productAttributeValueTable.setItems(FXCollections.observableList(productAttributeValueService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
