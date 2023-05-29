package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.ProductCategory;
import com.example.accessingdatamysql.dao.repo.ProductCategoryRepository;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.FactoryService;
import com.example.accessingdatamysql.service.ProductCategoryService;
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
@FxmlView("ProductCategories.fxml")
public class ProductCategoryController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<ProductCategoryDTO> productCategoriesTable;

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService service) {
        this.productCategoryService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductCategoryDTO item =  productCategoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productCategoryService.drop(item);
        productCategoriesTable.setItems(FXCollections.observableList(productCategoryService.getAll()));
    }

    private void editEvent() {
        ProductCategoryDTO item =  productCategoriesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productCategoryService.edit(ProductCategoryDTO.builder().name(name.getText()).build());
        productCategoriesTable.setItems(FXCollections.observableList(productCategoryService.getAll()));
    }

    private void addEvent() {
        try {
            ProductCategoryDTO item = ProductCategoryDTO.builder().name(name.getText()).build();
            productCategoryService.add(item);
            productCategoriesTable.setItems(FXCollections.observableList(productCategoryService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
