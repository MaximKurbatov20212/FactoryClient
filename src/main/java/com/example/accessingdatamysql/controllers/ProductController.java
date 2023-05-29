package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ProductService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Products.fxml")
public class ProductController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<ProductCategoryDTO> productCategoriesTable;
    @FXML private TableView<ProductTypeDTO> productTypesTable;
    @FXML private TableView<WorkshopDTO> workshopsTable;
    @FXML private TableView<ProductDTO> productsTable;
    private final ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductDTO item = productsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productService.drop(item);
        productsTable.setItems(FXCollections.observableList(productService.getAll()));
    }

    private void editEvent() {
        ProductDTO item = productsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        ProductCategoryDTO categoryItem = productCategoriesTable.getSelectionModel().getSelectedItem();
        if (categoryItem == null) {
            throw new ItemException("select record");
        }

        ProductTypeDTO typeItem = productTypesTable.getSelectionModel().getSelectedItem();
        if (typeItem == null) {
            throw new ItemException("select record");
        }

        WorkshopDTO workshopItem = workshopsTable.getSelectionModel().getSelectedItem();
        if (workshopItem == null) {
            throw new ItemException("select record");
        }


        productService.edit(ProductDTO.builder()
                .id(item.getId())
                .category(categoryItem)
                .workshop(workshopItem)
                .type(typeItem)
                .build()
        );

        productsTable.setItems(FXCollections.observableList(productService.getAll()));
    }

    private void addEvent() {
        try {
            ProductDTO item = productsTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            ProductCategoryDTO categoryItem = productCategoriesTable.getSelectionModel().getSelectedItem();
            if (categoryItem == null) {
                throw new ItemException("select record");
            }

            ProductTypeDTO typeItem = productTypesTable.getSelectionModel().getSelectedItem();
            if (typeItem == null) {
                throw new ItemException("select record");
            }

            WorkshopDTO workshopItem = workshopsTable.getSelectionModel().getSelectedItem();
            if (workshopItem == null) {
                throw new ItemException("select record");
            }

            productService.add(ProductDTO.builder()
                    .category(categoryItem)
                    .workshop(workshopItem)
                    .type(typeItem)
                    .build()
            );

            productsTable.setItems(FXCollections.observableList(productService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
