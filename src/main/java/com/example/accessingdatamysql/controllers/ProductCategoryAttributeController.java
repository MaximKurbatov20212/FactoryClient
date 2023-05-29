package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.ProductCategoryAttributeDTO;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ProductCategoryAttributeService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("ProductCategoryAttributes.fxml")
public class ProductCategoryAttributeController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField attrName;
    @FXML private TableView<ProductCategoryDTO> productCategoryTable;
    @FXML private TableView<ProductCategoryAttributeDTO> productCategoryAttributeTable;

    private final ProductCategoryAttributeService productCategoryAttributeService;

    public ProductCategoryAttributeController(ProductCategoryAttributeService service) {
        this.productCategoryAttributeService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductCategoryAttributeDTO item = productCategoryAttributeTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productCategoryAttributeService.drop(item);
        productCategoryAttributeTable.setItems(FXCollections.observableList(productCategoryAttributeService.getAll()));
    }

    private void editEvent() {
        ProductCategoryAttributeDTO item = productCategoryAttributeTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        ProductCategoryDTO categoryItem = productCategoryTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }


        productCategoryAttributeService.edit(ProductCategoryAttributeDTO.builder()
                .id(item.getId())
                .category(categoryItem)
                .attrName(attrName.getText())
                .build()
        );

        productCategoryAttributeTable.setItems(FXCollections.observableList(productCategoryAttributeService.getAll()));
    }

    private void addEvent() {
        try {
            ProductCategoryAttributeDTO item = productCategoryAttributeTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            ProductCategoryDTO categoryItem = productCategoryTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            productCategoryAttributeService.edit(ProductCategoryAttributeDTO.builder()
                    .category(categoryItem)
                    .attrName(attrName.getText())
                    .build()
            );

            productCategoryAttributeTable.setItems(FXCollections.observableList(productCategoryAttributeService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
